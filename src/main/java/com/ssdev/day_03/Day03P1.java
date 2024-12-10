package com.ssdev.day_03;

import java.io.IOException;
import java.util.*;

public class Day03P1 {
  private static Integer result = 0;
  public static Integer run () throws IOException{
    var input = Day03Input.getInput();

    input.forEach(item->{
      List<Integer[]> pairs = extractMuls(item);
      result += multiply(pairs);
    });

    return result;
  }

  private static Integer multiply(List<Integer[]> pairs) {
    if (pairs.equals(null) || pairs.size()==0) return 0;
    int res = 0;
    for (int i=0; i<pairs.size(); i++) {
      var pair = pairs.get(i);
      res += (pair[0] * pair[1]);
    }
    return res;
  }

  private static  List<Integer[]> extractMuls(String text) {
    final String PREFIX_TO_MATCH = "mul(";
    List<Integer[]> pairs = new ArrayList<>();
    String prefix="", mul_args[];

    try {
      for (int i=0; i<text.length(); i++) {
        if (text.charAt(i) == 'm') {
          StringBuilder sb = new StringBuilder();
          for (int c=i; c<i+4; c++) {
            sb.append(text.charAt(c));
          }

          prefix = sb.toString();
        }

        if (prefix.equals(PREFIX_TO_MATCH)) {
          for (int c=i+7; c<i+12; c++) {
            if (text.charAt(c) == ')') {
              var mul = text.substring(i,c+1);
              mul_args = mul.substring(4,mul.length()-1).split(",");
              if (mul_args.length!=2) {
                prefix = "";
                break;
              }
              Integer pair[] = {
                Integer.valueOf(mul_args[0]),
                Integer.valueOf(mul_args[1])
              };
              pairs.add(pair);
              break;
            }
          }
        }

        prefix = "";
        continue;
      }
    } catch (IndexOutOfBoundsException e) {
      System.out.println(e);
    }

    return pairs;
  }
}
