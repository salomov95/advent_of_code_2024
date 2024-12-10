package com.ssdev.day_04;

import com.ssdev.Input;

import java.util.*;
import java.io.IOException;

public class Day04Input {
  public static List<String> getInput() throws IOException {
    String fileName = "day_04/input_full.txt";
    //String fileName = "day_04/sample.txt";

    return Input.getInput(fileName);
  }
}
