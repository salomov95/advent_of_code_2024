package com.ssdev.day_04;
import java.util.Set;
import java.util.List;
import java.io.IOException;

public class Day04P2 {
  public static Integer run() throws IOException {
    var input = Day04Input.getInput();
    int x_mas_count = findCrossWord(input);
    return x_mas_count;
  }

  private static int findCrossWord(List<String> input) {
    int cross_word_count = 0;
    for (int l=0; l<input.size()-2; l++) {
      for (int c=0; c<input.get(l).length()-2; c++) {
        var top = input.get(l).substring(c, c+3);
        var mid = input.get(l+1).substring(c, c+3);
        var bot = input.get(l+2).substring(c, c+3);

        var hCW = hasCrossedWords(List.of(top,mid,bot));

        if (hCW) {
          cross_word_count++;
        }
        continue;
      }
    }
    return cross_word_count;
  }

  private static boolean hasCrossedWords(List<String> mtx) {
    final Set<String> ACCEPTED = Set.of(
      "MAS","SAM");

    //System.out.println(mtx.get(0));
    //System.out.println(mtx.get(1));
    //System.out.println(mtx.get(2));
    
    String word1 = "" +
      mtx.get(0).charAt(0) +
      mtx.get(1).charAt(1) +
      mtx.get(2).charAt(2);
    
    String word2 = "" +
      mtx.get(0).charAt(2) +
      mtx.get(1).charAt(1) +
      mtx.get(2).charAt(0);
    
    var tmp = ACCEPTED.contains(word1) &&
              ACCEPTED.contains(word2);
    
    return tmp;
  }
}
