package com.ssdev.day_05;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class Day05P1 {
  private static Integer middle_sum = 0;
  public static Integer run () throws IOException {
    var input = Day05Input.getInput();

    List<String> rules  = input.get(0);
    List<String> pages  = input.get(1);

    List<String> pages_ok = new ArrayList<>();

    pages.forEach(p->{
      var page = p.split(",");
      List<Boolean> rule_matches = new ArrayList<>();
      for (int i=0; i<page.length; i++) {
        if (i+1>=page.length) break;
        String tmp_rule = page[i] + "|" + page[i+1];
        rule_matches.add(rules.contains(tmp_rule));
      }
      if (rule_matches.stream().allMatch(t->!!t)) {
        pages_ok.add(p);
      }
    });

    pages_ok.forEach(p->{
      var page_split = p.split(",");
      var middle = Integer.valueOf(
        page_split[page_split.length/2]);
      middle_sum += middle;
    });

    return middle_sum;
  }
}
