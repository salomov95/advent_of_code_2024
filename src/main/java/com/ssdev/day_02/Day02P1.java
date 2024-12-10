package com.ssdev.day_02;

import java.io.IOException;
import java.util.*;

public class Day02P1 {
  private static int safe_reports_count = 0;

  public static Integer run() throws IOException {
    var input = Day02Input.getInput();

    input.forEach(report->{
      if(isSafeReport(report)) {
        safe_reports_count++;
      }
    });

    return safe_reports_count;
  }

  private static boolean isSafeReport(List<Integer> report) {
    Set<Integer> accepted = Set.of(1,2,3);
    List<String> variance_type = new ArrayList<>();
    List<Integer> variety_amount = new ArrayList<>();
    
    for (int i=0; i<report.size(); i++) {
      if (i+1 == report.size()) break;
      
      var amount = report.get(i) - report.get(i+1);
      variety_amount.add(Math.abs(amount));

      if (amount < 0) {
        variance_type.add("increase");
      } else if (amount > 0) {
        variance_type.add("decrease");
      } else {
        variance_type.add("neutral");
      }
    }

    var isAllIncreasing = variance_type
      .stream()
      .allMatch(type->type.equals("increase"));

    var isAllDecreasing = variance_type
      .stream()
      .allMatch(type->type.equals("decrease"));

    var isAllInsideSafeAmount = variety_amount
      .stream()
      .allMatch(accepted::contains);

    return (isAllIncreasing || isAllDecreasing) && isAllInsideSafeAmount;
  }
}
