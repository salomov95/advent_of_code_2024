package com.ssdev.day_01;

import java.io.IOException;

public class Day01P2 {
  public static Integer run() throws IOException {
    var input = Day01Input.getInput();
    var left = input.get("left");
    var right = input.get("right");

    var size = input.get("left").size();
    int similarity_score = 0;

    for (int i=0; i<size; i++) {
      int count = 0;
      for (int j=0; j<size; j++) {
        if (left.get(i).equals(right.get(j))) {
          count++;
        }
      }
      similarity_score += (left.get(i) * count);
    }

    return similarity_score;
  }
}
