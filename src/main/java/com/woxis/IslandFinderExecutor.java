package com.woxis;

import com.woxis.island.IslandFinder;
import com.woxis.island.IslandMap;
import com.woxis.parser.MapParser;
import com.woxis.parser.MapValidator;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class IslandFinderExecutor {
  private final MapParser mapParser;
  private final MapValidator mapValidator;
  private final IslandFinder islandFinder;

  IslandFinderStatistics findIslandsForFile(String filename) {
    long parsingStart = System.currentTimeMillis();
    Optional<IslandMap> islandMap = mapParser.parseMap(filename);
    long parsingEnd = System.currentTimeMillis();
    long parsingTimeInMillis = parsingEnd - parsingStart;

    islandMap.ifPresent(map -> {
      mapValidator.validate(map);
      map.printMap();
    });

    long searchingStart = System.currentTimeMillis();
    Long islandFound = islandMap.map(islandFinder::countIslands).orElse(0L);
    long searchingEnd = System.currentTimeMillis();
    long searchingTimeInMillis = searchingEnd - searchingStart;

    return new IslandFinderStatistics(islandFound, searchingTimeInMillis, parsingTimeInMillis);
  }

}
