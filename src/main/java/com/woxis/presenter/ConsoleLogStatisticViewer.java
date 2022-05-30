package com.woxis.presenter;

import com.woxis.IslandFinderStatistics;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsoleLogStatisticViewer {

  public static void printStatistics(IslandFinderStatistics statistics) {
    log.info("Found " + statistics.islandsFound() + " islands within: " + statistics.searchingTimeInMillis() + " millis.");
    log.info("It took: " + statistics.parsingTimeInMillis() + " millis to parse the file.");
  }
}
