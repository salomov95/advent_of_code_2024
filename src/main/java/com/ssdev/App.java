package com.ssdev;

import com.ssdev.day_01.*;
import com.ssdev.day_02.*;
import com.ssdev.day_03.*;
import com.ssdev.day_04.*;
import com.ssdev.day_05.*;
import com.ssdev.day_06.*;

public class App {
  public static void main( String[] args ) {
    var day = 0;
    var result = 0;
    var part = 0;
    try {
      switch(args[0]) {
        case "Day01P1":
          result = Day01P1.run();
          day = 1;
          part = 1;
          break;
        case "Day01P2":
          result = Day01P2.run();
          day = 1;
          part = 2;
          break;
        case "Day02P1":
          result = Day02P1.run();
          day = 2;
          part = 1;
          break;
        case "Day02P2":
          result = Day02P2.run();
          day = 2;
          part = 2;
          break;
        case "Day03P1":
          result = Day03P1.run();
          day = 3;
          part = 1;
          break;
        case "Day03P2":
          result = Day03P2.run();
          day = 3;
          part = 2;
          break;
        case "Day04P1":
          result = Day04P1.run();
          day = 4;
          part = 1;
          break;
        case "Day04P2":
          result = Day04P2.run();
          day = 4;
          part = 2;
          break;
        case "Day05P1":
          result = Day05P1.run();
          day = 5;
          part = 1;
          break;
        case "Day05P2":
          result = Day05P2.run();
          day = 5;
          part = 2;
          break;
        case "Day06P1":
          result = Day06P1.run();
          day = 6;
          part = 1;
          break;
        case "Day06P2":
          result = Day06P2.run();
          day = 6;
          part = 2;
          break;
        default:
          System.out.println("[WARN] No Available Challenge For Given Day.");
          break;
      }

    } catch (Exception e) {
      System.out.println(e);
    }
    System.out.println("[DAY 0" +  day + "] Part 0" + part +" Answer :: " + result);
  }
}
