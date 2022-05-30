package com.woxis;

import com.woxis.island.DFSIslandFinder;
import com.woxis.island.IslandFinder;
import com.woxis.parser.MapParser;
import com.woxis.parser.MapValidator;
import com.woxis.presenter.ConsoleLogStatisticViewer;

public class Main {

  public static void main(String[] args) {
    MapParser mapParser = new MapParser();
    MapValidator mapValidator = new MapValidator();
    IslandFinder islandFinder = new DFSIslandFinder();
    IslandFinderExecutor islandFinderExecutor = new IslandFinderExecutor(mapParser, mapValidator, islandFinder);

    IslandFinderStatistics statistics = islandFinderExecutor.findIslandsForFile("3.txt");
    ConsoleLogStatisticViewer.printStatistics(statistics);
  }

}
