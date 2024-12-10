package com.ssdev.day_05;

public class Day05Utils {
  public static String toStringArray(String[] array) {
    String result = "" + array[array.length-1];
    for (int i=array.length-2; i>=0; i--) {
      String tmp = array[i] + "," + result;
      result = tmp;
    }
    return result;
  }
  public static void printArray(String prefix,String[] array) {
    System.out.println(prefix + toStringArray(array));
  }
}
