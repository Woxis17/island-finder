package com.woxis;

import com.woxis.island.IslandFinder;
import com.woxis.island.SimpleIslandFinder;
import com.woxis.parser.MapParser;
import com.woxis.parser.MapValidator;

public class Main {

  public static void main(String[] args) {
    MapParser mapParser = new MapParser();
    MapValidator mapValidator = new MapValidator();
    IslandFinder islandFinder = new SimpleIslandFinder();
    IslandFinderExecutor islandFinderExecutor = new IslandFinderExecutor(mapParser, mapValidator, islandFinder);

    IslandFinderStatistics statistics = islandFinderExecutor.findIslandsForFile("1.txt");
    statistics.printStatistics();
  }

}
