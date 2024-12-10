package com.ssdev.day_05;

import java.util.List;
import java.util.ArrayList;
import com.ssdev.Input;
import java.io.IOException;

public class Day05Input {
  public static List<List<String>> getInput() throws IOException {
    String fileName = "day_05/input_full.txt";
    //String fileName = "day_05/sample.txt";
    List<String> input = Input.getInput(fileName);
    List<String> rules = new ArrayList<>();
    List<String> pages = new ArrayList<>();
    input.forEach(i->{
      if (i.contains("|")) rules.add(i);
      if (i.contains(",")) pages.add(i);
    });
    return List.of(rules, pages);
  }
}
