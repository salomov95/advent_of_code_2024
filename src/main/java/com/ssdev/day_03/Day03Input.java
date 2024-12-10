package com.ssdev.day_03;

import com.ssdev.Input;

import java.util.*;
import java.io.IOException;

public class Day03Input {
  public static List<String> getInput() throws IOException {
    String fileName = "day_03/input_full.txt";
    //String fileName = "day_03/sample.txt";
    //String fileName = "day_03/sample_part2.txt";
    return Input.getInput(fileName);
  }
}
