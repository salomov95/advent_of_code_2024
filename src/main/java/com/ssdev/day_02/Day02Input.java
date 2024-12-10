package com.ssdev.day_02;

import com.ssdev.Input;

import java.util.*;
import java.io.IOException;

public class Day02Input {
  public static List<List<Integer>> getInput() throws IOException {
    //String fileName = "day_02/sample.txt";
    //String fileName = "day_02/edge_cases.txt";
    String fileName = "day_02/input_full.txt";
    List<String> file = Input.getInput(fileName);
    List<List<Integer>> list = new ArrayList<>();

    file.forEach(line->{
      List<Integer> ls = new ArrayList<>();
      var lineSplit = line.split(" ");

      for (int i=0; i<lineSplit.length; i++) {
        ls.add(Integer.valueOf(lineSplit[i]));
      }

      list.add(ls);
    });

    return list;
  }
}
