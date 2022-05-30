package com.woxis.island;

/**
 * DFS - Deep First Search
 */
public class DFSIslandFinder implements IslandFinder {

  private static final int[] ROW_NEIGHBOURS = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
  private static final int[] COL_NEIGHBOURS = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

  @Override
  public long countIslands(IslandMap islandMap) {

    boolean[][] visitedTiles = new boolean[islandMap.getMapHeight()][islandMap.getMapWidth()];

    int count = 0;
    for (int i = 0; i < islandMap.getMapHeight(); ++i) {
      for (int j = 0; j < islandMap.getMapWidth(); ++j)
        if (islandMap.getMap()[i][j] == 1 && !visitedTiles[i][j]) {
          dfs(islandMap, i, j, visitedTiles);
          count++;
        }
    }
    return count;
  }

  private void dfs(IslandMap islandMap, int row, int col, boolean[][] visitedTiles) {
    visitedTiles[row][col] = true;
    for (int k = 0; k < 8; ++k) {
      if (canVisit(islandMap, row + ROW_NEIGHBOURS[k], col + COL_NEIGHBOURS[k], visitedTiles))
        dfs(islandMap, row + ROW_NEIGHBOURS[k], col + COL_NEIGHBOURS[k], visitedTiles);
    }
  }

  boolean canVisit(IslandMap islandMap, int row, int col, boolean visitedTiles[][]) {
    return row >= 0 && row < islandMap.getMapHeight() && col >= 0 && col < islandMap.getMapWidth()
        && islandMap.getMap()[row][col] == 1 && !visitedTiles[row][col];
  }

}
