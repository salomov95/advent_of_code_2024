package com.ssdev.day_01;

import com.ssdev.Input;
import java.util.*;

import java.io.IOException;

public class Day01Input {
  public static Map<String, List<Integer>> getInput() throws IOException {
    String fileName = "day_01/input_full.txt";
    List<String> file = Input.getInput(fileName);

    List<Integer> l = new ArrayList<>();
    List<Integer> r = new ArrayList<>();

    file.forEach(line->{
      var lineSplit = line.split("   ");
      l.add(Integer.valueOf(lineSplit[0]));
      r.add(Integer.valueOf(lineSplit[1]));
    });

    Map<String, List<Integer>> map = new HashMap<>();
    map.put("left", l);
    map.put("right", r);

    return map;
  }
}
