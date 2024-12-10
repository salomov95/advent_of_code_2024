package com.ssdev.day_01;

import java.util.Collections;
import java.io.IOException;

public class Day01P1 {
  public static Integer run() throws IOException {
    var input = Day01Input.getInput();

    var left = input.get("left");
    var right = input.get("right");

    Collections.sort(left);
    Collections.sort(right);

    var size = input.get("left").size();
    int distance = 0;

    for (int i=0; i<size; i++) {
      var l = left.get(i);
      var r = right.get(i);
      if (l>r) {
        distance += (l - r);
      } else {
        distance += (r - l);
      }
    }

    return distance;
  }
}
