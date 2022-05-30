package com.woxis.island;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class SimpleIslandFinder implements IslandFinder {

  @Override
  public long countIslands(IslandMap islandMap) {
    List<Island> discoveredIslands = new ArrayList<>();

    for (int row = 0; row < islandMap.getMapHeight(); row++) {
      for (int col = 0; col < islandMap.getMapWidth(); col++) {
        if (isLandTile(islandMap, row, col)) {
          visitLandTile(col, row, discoveredIslands);
        }
      }
    }
    return discoveredIslands.size();
  }

  private boolean isLandTile(IslandMap islandMap, int row, int col) {
    return islandMap.getMap()[row][col] == 1;
  }

  private void visitLandTile(int col, int row, List<Island> islands) {
    Point visitedTile = new Point(col, row);
    List<Island> islandsAdjacentToNewTile = islands.stream()
        .filter(island -> island.isPointAdjacent(visitedTile)).toList();

    if (islandsAdjacentToNewTile.isEmpty()) {
      addNewIsland(islands, visitedTile);
    } else if (islandsAdjacentToNewTile.size() == 1) {
      addVisitedTileToExistingIsland(islandsAdjacentToNewTile.get(0), visitedTile);
    } else {
      joinAdjacentIslands(islands, visitedTile, islandsAdjacentToNewTile);
    }
  }

  private void addNewIsland(List<Island> islands, Point visitedTile) {
    Island newIsland = new Island();
    addVisitedTileToExistingIsland(newIsland, visitedTile);
    islands.add(newIsland);
  }

  private void addVisitedTileToExistingIsland(Island islandsAdjacentToNewTile, Point visitedTile) {
    islandsAdjacentToNewTile.addPoint(visitedTile);
  }

  private void joinAdjacentIslands(List<Island> islands, Point islandPoint, List<Island> adjacentIslands) {
    Set<Point> mergedIslandPoints = adjacentIslands.stream()
        .flatMap(island -> island.getIslandPoints().stream())
        .collect(Collectors.toSet());
    mergedIslandPoints.add(islandPoint);

    adjacentIslands.forEach(islands::remove);
    Island mergedIsland = new Island(mergedIslandPoints);
    islands.add(mergedIsland);
  }

}
