package com.woxis.island;

import lombok.Data;

@Data
public class IslandMap {

  private int x;
  private int y;
  private Byte[][] map;

  public IslandMap(Byte[][] map, int x, int y) {
    this.map = map;
    this.x = x;
    this.y = y;
  }

  public void printMap() {
    if (x < 100 && y < 100) {
      for (int y = 0; y < getY(); y++) {
        for (int x = 0; x < getX(); x++) {
          if (map[y][x] == 1) {
            System.out.print("1 ");
          } else {
            System.out.print("0 ");
          }
        }
        System.out.println("/");
      }
    } else {
      System.out.println("Map is printed only for maps which are less then 100 in any dimension");
    }
  }

}
