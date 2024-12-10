package com.ssdev.day_05;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public class Day05P2 {
  private static Integer middle_sum = 0;
  private static List<String> rules;
  
  public static Integer run () throws IOException {
    var input = Day05Input.getInput();

    rules = input.get(0);
    List<String> pages  = input.get(1);
    List<String> pages_to_fix = new ArrayList<>();

    pages.forEach(p->{
      if (!checkPage(p)) {
        pages_to_fix.add(p);
      }
    });

    List<String> pages_fixed = fixPages(pages_to_fix);
    System.out.println(pages_fixed);

    pages_fixed.forEach(p->{
      var p_split = p.split(",");
      var middle = Integer.valueOf(
        p_split[p_split.length/2]);
      middle_sum += middle;
    });

    return middle_sum;
  }

  private static Boolean checkPage(String page) {
    List<Boolean> rule_matches = new ArrayList<>();
    String pageSplit[] = page.split(",");
    
    for (int i=0; i<pageSplit.length; i++) {
      if (i+1>=pageSplit.length) break;
      
      String tmp_rule = pageSplit[i] + "|" + pageSplit[i+1];
      
      rule_matches.add(rules.contains(tmp_rule));
    }

    return rule_matches.stream().allMatch(t->!!t);
  }

  private static List<String> fixPages (List<String> pages) {
    List<String> pages_fixed = new ArrayList<>();
    
    for (int p=0; p<pages.size(); p++) {
      var page_fixed = fixPage(pages.get(p));
      pages_fixed.add(page_fixed);
    };

    return pages_fixed;
  }

  private static String fixPage (String page) {
    var page_arr = page.split(",");
    while(true) {
      for (int i=0; i<page_arr.length-1; i++) {
        var tmp_rule = page_arr[i] + "|" + page_arr[i+1];
        if (rules.contains(tmp_rule)) continue;
        String left=page_arr[i], right=page_arr[i+1];
        page_arr[i] = right;
        page_arr[i+1] = left;
      }
      if (checkPage(Day05Utils.toStringArray(page_arr))) break;
    }
    return Day05Utils.toStringArray(page_arr);
  }
}
