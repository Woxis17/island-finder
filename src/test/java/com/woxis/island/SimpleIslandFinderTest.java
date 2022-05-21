package com.woxis.island;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleIslandFinderTest {

  IslandFinder islandFinder = new SimpleIslandFinder();

  @Test
  void shouldFindZeroIslandForEmptyMap() {
    // given:
    IslandMap emptyMap = new IslandMap(new Byte[0][0], 0, 0);

    // when:
    long islandCount = islandFinder.countIslands(emptyMap);

    // then:
    assertEquals(0L, islandCount);
  }

  @Test
  void shouldFindZeroIslandForOnlyWaterMap() {
    // given:
    Byte[][] map = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    IslandMap onlyWaterMap = new IslandMap(map, 3, 3);

    // when:
    long islandCount = islandFinder.countIslands(onlyWaterMap);

    // then:
    assertEquals(0L, islandCount);
  }

  @Test
  void shouldFindOneIslandForOnlyLandMap() {
    // given:
    Byte[][] map = {{1, 1}, {1, 1}, {1, 1}};
    IslandMap onlyLandMap = new IslandMap(map, 2, 3);

    // when:
    long islandCount = islandFinder.countIslands(onlyLandMap);

    // then:
    assertEquals(1L, islandCount);
  }

  @Test
  void shouldFindTwoIslandForWaterLandMap() {
    // given:
    Byte[][] map = {{1, 1}, {0, 0}, {1, 1}};
    IslandMap islandMap = new IslandMap(map, 2, 3);

    // when:
    long islandCount = islandFinder.countIslands(islandMap);

    // then:
    assertEquals(2L, islandCount);
  }

  @Test
  void shouldFindFourIslandForMapFromExample() {
    // given:
    Byte[][] map = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 0, 0, 0, 0, 0},
        {1, 1, 1, 0, 0, 0, 1, 0, 0},
        {1, 1, 0, 0, 0, 1, 1, 1, 0},
        {0, 0, 0, 0, 0, 0, 1, 1, 0},
        {0, 0, 1, 0, 0, 0, 0, 0, 0},
        {1, 1, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 1, 1, 0, 0}
    };
    IslandMap islandMap = new IslandMap(map, 9, 8);

    // when:
    long islandCount = islandFinder.countIslands(islandMap);

    // then:
    assertEquals(4L, islandCount);
  }
}