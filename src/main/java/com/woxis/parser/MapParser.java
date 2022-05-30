package com.woxis.parser;

import com.woxis.island.IslandMap;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Optional;

import static com.woxis.parser.IslandMapProperties.MAX_ALLOWED_SIZE;

@Slf4j
public class MapParser {

  private static final String ISLAND_TILE = "1";
  private static final String WATER_TILE = "0";
  private static final String DELIMITER = " ";

  public Optional<IslandMap> parseMap(String fileName) {
    ClassLoader classLoader = getClass().getClassLoader();
    try (InputStream is = classLoader.getResourceAsStream(fileName);
         BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
      Byte[][] map = reader.lines()
          .map(line -> line.split(DELIMITER))
          .map(arrayString -> Arrays.stream(arrayString)
              .map(this::convertToByte)
              .limit(MAX_ALLOWED_SIZE + 1)
              .toArray(Byte[]::new))
          .limit(MAX_ALLOWED_SIZE + 1)
          .toArray(Byte[][]::new);
      checkXDimensionIsAligned(map);
      int yDimension = map.length;

      return Optional.of(new IslandMap(map, getXDimensionSize(map), yDimension));
    } catch (IOException e) {
      log.error("Cannot parse map");
    }
    return Optional.empty();
  }

  private byte convertToByte(String element) {
    if (ISLAND_TILE.equals(element)) {
      return 1;
    } else if (WATER_TILE.equals(element)) {
      return 0;
    } else throw new MapParsingException();
  }

  private void checkXDimensionIsAligned(Byte[][] map) {
    int xDimensionLengthInFistRow = map[0].length;
    if (Arrays.stream(map).anyMatch(row -> row.length != xDimensionLengthInFistRow)) {
      throw new MapParsingException("X Dimensions different in sizes");
    }
  }

  private int getXDimensionSize(Byte[][] map) {
    return map[0].length;
  }

}
