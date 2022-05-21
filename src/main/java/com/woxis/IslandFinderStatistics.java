package com.woxis;

record IslandFinderStatistics(long islandsFound, long searchingTimeInMillis, long parsingTimeInMillis) {

  void printStatistics() {
    System.out.println("Found " + islandsFound + " islands within: " + searchingTimeInMillis + " millis.");
    System.out.println("It took: " + parsingTimeInMillis + " millis to parse the file.");
  }

}
