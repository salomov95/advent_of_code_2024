package com.ssdev.day_04;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
public class Day04P1 {
  public static Integer run() throws IOException {
    List<String> input = Day04Input.getInput();
    return findWord(input);
  }
  private static Integer findWord(List<String> input) {
    var hrz = findWordHorizontal(input);
    System.out.println("[DEBUG] HORIZONTAL :: " + hrz);
    var vert = findWordVertical(input);
    System.out.println("[DEBUG] VERTICAL :: " + vert);
    var diag = findWordDiagonal(input);
    System.out.println("[DEBUG] DIAGONAL 1 :: " + diag);
    var diagRev = findWordDiagonalReverse(input);
    System.out.println("[DEBUG] DIAGONAL 2 :: " + diagRev);
    return (hrz + vert + diag + diagRev);
  }
  private static Integer findWordHorizontal (List<String> input) {
    final Set<String> WORDS = Set.of(
      "XMAS","SAMX");
    int word_count = 0;
    for (int h=0; h<input.size(); h++) {
      int tmp_count = 0;
      String line = input.get(h);
      for (int w=0; w<line.length(); w++) {
        if (w+4 > line.length()) continue;
        String sub = line.substring(w, w+4);
        if (WORDS.contains(sub)) {
          tmp_count++;
        }
      }
      word_count+=tmp_count;
    }
    return word_count;
  }
  private static Integer findWordVertical (List<String> input) {
    final int LINE_SIZE = input.get(0).length();
    final int COLUMN_SIZE = input.size();
    List<String> lineRotated = new ArrayList<>();
    for (int w=0; w<LINE_SIZE; w++) {
      String line = "";      
      for (int h=0; h<COLUMN_SIZE; h++) {
        line += input.get(h).charAt(w);
      }
      lineRotated.add(line);
    }
    return findWordHorizontal(lineRotated);
  }
  private static Integer findWordDiagonal (List<String> input) {
    final int LINE_SIZE = input.get(0).length();
    final int COLUMN_SIZE = input.size();
    List<String> lineRotated = new ArrayList<>();
    for (int l=0; l<LINE_SIZE; l++) {
      if (l+1 >= LINE_SIZE) break;
      String line = "" + input.get(0).charAt(l);
      int c = l+1;
      for (int h=1; h<COLUMN_SIZE; h++) {
        if (c>=input.get(h).length()) break;
        line += input.get(h).charAt(c);
        c++;
      }
      if (line.length()>=4) {
        lineRotated.add(line);
      }
    }
    for (int l=LINE_SIZE-2; l>0; l--) {
      if (l-1 < 0) break;
      String line = "" + input.get(COLUMN_SIZE-1).charAt(l);
      int c = l-1;
      for (int h=COLUMN_SIZE-2; h>0; h--) {
        if (c<0) break;
        var tmp = input.get(h).charAt(c) + line;
        line = tmp;
        c--;
      }
      if (line.length()>=4) {
        lineRotated.add(line);
      }
    }
    return findWordHorizontal(lineRotated);
  }
  private static Integer findWordDiagonalReverse (List<String> input) {
    final int LINE_SIZE = input.get(0).length();
    final int COLUMN_SIZE = input.size();
    List<String> lineRotated = new ArrayList<>();
    for (int l=0; l<LINE_SIZE; l++) {
      if (l+1 >= LINE_SIZE) break;
      String line = "" + input.get(COLUMN_SIZE-1).charAt(l);
      int c = l+1;
      for (int h=COLUMN_SIZE-2; h>=0; h--) {
        if (c>=input.get(h).length()) break;
        line += input.get(h).charAt(c);
        c++;
      }
      if (line.length()>=4) {
        lineRotated.add(line);
      }
    }
    for (int l=LINE_SIZE-2; l>0; l--) {
      if (l-1 < 0) break;
      String line = "" + input.get(0).charAt(l);
      int c = l-1;
      for (int h=1; h<COLUMN_SIZE; h++) {
        if (c<0) break;
        var tmp = input.get(h).charAt(c) + line;
        line = tmp;
        c--;
      }
      if (line.length()>=4) {
        lineRotated.add(line);
      }
    }
    return findWordHorizontal(lineRotated);
  }
}
