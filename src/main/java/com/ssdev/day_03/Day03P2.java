package com.ssdev.day_03;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.regex.*;
import java.util.*;
public class Day03P2 {
  private static Integer result = 0;
  public static Integer run() throws IOException{
    var input = Day03Input.getInput();
    input.forEach(item->{
      var tmp = extractMuls(item);
      tmp.forEach(t->multiply(t));
    });
    return result;
  }
  private static void multiply(List<Integer> input) {
    result += (input.get(0) * input.get(1));
  }
  private static List<List<Integer>> extractMuls(String text) {
    List<List<Integer>> queue = new ArrayList<>();
    boolean can_execute = true;
    String regex = "mul\\(\\d{1,3},\\d{1,3}\\)|do\\(\\)|don't\\(\\)";
    Pattern mulPattern = Pattern.compile(regex);
    var matches = mulPattern
      .matcher(text)
      .results()
      .map(result->result.group(0))
      .collect(Collectors.toList());
    for (int i=0; i<matches.size(); i++) {
      if (matches.get(i).equals("don't()")) {
        can_execute = false;
      }
      if (matches.get(i).equals("do()")) {
        can_execute = true;
      }
      if (matches.get(i).startsWith("mul")) {
        if (can_execute) {
          var match = matches.get(i);
          if (match.contains(" ")) {
            continue;
          }
          var tmp = match
            .replace("mul(","")
            .replace(")","")
            .split(",");
          queue.add(List.of(
            Integer.valueOf(tmp[0]),
            Integer.valueOf(tmp[0])
          ));
        }
      }
    }
    return queue;
  }
}
