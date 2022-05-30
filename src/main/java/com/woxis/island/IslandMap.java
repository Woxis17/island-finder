package com.woxis.island;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class IslandMap {

  private int mapWidth;
  private int mapHeight;
  private Byte[][] map;

  public IslandMap(Byte[][] map, int mapWidth, int mapHeight) {
    this.map = map;
    this.mapWidth = mapWidth;
    this.mapHeight = mapHeight;
  }

  public void printMap() {
    StringBuilder sb = new StringBuilder("\n");
    if (mapWidth < 100 && mapHeight < 100) {
      for (int y = 0; y < getMapHeight(); y++) {
        for (int x = 0; x < getMapWidth(); x++) {
          if (map[y][x] == 1) {
            sb.append("1 ");
          } else {
            sb.append("0 ");
          }
        }
        sb.append("\n");
      }
      log.info(sb.toString());
    } else {
      log.info("Map is printed only for maps which are less then 100 in any dimension");
    }
  }

}
