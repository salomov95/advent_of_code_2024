package com.ssdev.day_06;

import java.util.List;
import com.ssdev.Input;
import java.io.IOException;

public class Day06Input {
  public static List<String> getInput() throws IOException {
    String fileName = "day_06/sample.txt";
    //String fileName = "day_06/input_full.txt";
    return Input.getInput(fileName);
  }
}
