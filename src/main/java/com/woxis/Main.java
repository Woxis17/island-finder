package com.woxis;

import com.woxis.island.IslandFinder;
import com.woxis.island.IslandMap;
import com.woxis.island.SimpleIslandFinder;
import com.woxis.parser.MapParser;
import com.woxis.parser.MapValidator;

import java.util.Optional;

public class Main {

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    long islandCounts = calculateIslands();
    long end = System.currentTimeMillis();
    long duration = end - start;
    System.out.println("Found " + islandCounts + " islands within: " + duration + " millis.");
  }

  private static long calculateIslands() {
    MapParser mapParser = new MapParser();
    MapValidator mapValidator = new MapValidator();

    Optional<IslandMap> islandMap = mapParser.parseMap("1.txt");
    return islandMap.map(island -> {
      mapValidator.validate(island);
      island.printMap();
      IslandFinder islandFinder = new SimpleIslandFinder();
      return islandFinder.countIslands(islandMap.get());
    }).orElse(0L);
  }

}
