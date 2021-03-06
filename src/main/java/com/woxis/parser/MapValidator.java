package com.woxis.parser;

import com.woxis.island.IslandMap;

import static com.woxis.parser.IslandMapProperties.MAX_ALLOWED_SIZE;

public class MapValidator {

  public void validate(IslandMap islandMap) {
    if (islandMap.getMapWidth() > MAX_ALLOWED_SIZE || islandMap.getMapHeight() > MAX_ALLOWED_SIZE) {
      throw new MapToBigException();
    }
  }
}
