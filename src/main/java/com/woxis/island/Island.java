package com.woxis.island;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
class Island {

  @Getter
  private Set<Point> islandPoints = new HashSet<>();

  Island(Set<Point> islandPoints) {
    this.islandPoints = islandPoints;
  }

  boolean isPointAdjacent(Point point) {
    return islandPoints.stream()
        .anyMatch(p -> isAdjacent(p, point));
  }

  boolean addPoint(Point point) {
    return islandPoints.add(point);
  }

  private boolean isAdjacent(Point p1, Point p2) {
    return Math.abs(p1.x() - p2.x()) <= 1 && Math.abs(p1.y() - p2.y()) <= 1;
  }

}
