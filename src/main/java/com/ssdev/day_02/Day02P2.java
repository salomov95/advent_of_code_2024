package com.ssdev.day_02;

import java.io.IOException;
import java.util.*;

public class Day02P2 {
  private static int safe_reports_count = 0;

  public static Integer run() throws IOException {
    var input = Day02Input.getInput();

    input.forEach(report->{
      boolean safety = isSafeReport(report, -1);
      
      if (safety) {
        safe_reports_count++;
      }
    });

    return safe_reports_count;
  }

  private static boolean isSafeReport(
      List<Integer> input, int offset) {
    // Recursive Break Condition
    if (offset>=input.size()) return false;

    // Copy Input For Safer Operations
    List<Integer> report = new ArrayList<>();
    for (int i=0; i<input.size(); i++) {
      if (i!=offset) {
        report.add(input.get(i));
      }
    };

    Set<Integer> accepted = Set.of(1,2,3);
    List<Integer> variances = new ArrayList<>();
    boolean earlyFail = false;

    for (int i=0; i<report.size(); i++) {
      if (i+1 == report.size()) break;
      int curr = report.get(i);
      int next = report.get(i+1);

      if (i-1>=0) {
        int prev = report.get(i-1);

        // Punctual Fluctuation On Variations
        if (
          ((prev - curr > 0) && (curr - next < 0)) ||
          ((prev - curr < 0) && (curr - next > 0))
        ) {
          earlyFail = true;
          break;
        }
      }
      
      var amount = curr - next;
      var absAmount = Math.abs(amount);
      variances.add(absAmount);

      // Track Variation Limit
      if(!accepted.contains(absAmount) || amount==0) {
        earlyFail = true;
        break;
      }
    }

    if (earlyFail) {
      return isSafeReport(input, offset+1);
    }

    // Track If Matches All Requirements
    var isAllIncreasing = variances
      .stream().allMatch(v->v<0);
    var isAllDecreasing = variances
      .stream().allMatch(v->v>0);

    return isAllIncreasing || isAllDecreasing;
  }
}
