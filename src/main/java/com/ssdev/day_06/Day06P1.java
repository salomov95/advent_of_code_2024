package com.ssdev.day_06;

import java.util.*;
import java.io.IOException;

public class Day06P1 {
  private static List<String> map;

  public static Integer run() throws IOException {
    map = Day06Input.getInput();

    List<Integer[]> g_positions = new ArrayList<>();

    // Position Shape [x, y]
    var start_pos = findCurrentPosition();
    g_positions.add(start_pos);

    while (true) {
      Integer curr_pos[] = g_positions
        .get(g_positions.size()-1);

      if (hasExitedMap(curr_pos)) break;

      char direction = map
        .get(curr_pos[1])
        .charAt(curr_pos[0]);

      Integer next_step[] = {0,0};
      
      switch (direction) {
        case '>':
          next_step[0] = curr_pos[0]+1;
          next_step[1] = curr_pos[1];
          break;
        case 'v':
          next_step[0] = curr_pos[0];
          next_step[1] = curr_pos[1]+1;
          break;
        case '<':
          next_step[0] = curr_pos[0]-1;
          next_step[1] = curr_pos[1];
          break;
        case '^':
        default:
          next_step[0] = curr_pos[0];
          next_step[1] = curr_pos[1]-1;
          break;
      }

      var next_pos = map
        .get(next_step[1])
        .charAt(next_step[0]);


      if (next_pos == '#') {
        char new_direction = rotateDirection(direction);
        updateMapLine(new_direction, curr_pos);
      } else {
        g_positions.add(next_step);

        updateMapLine('.', curr_pos);
        updateMapLine(direction, next_step);
      }
    }

    return countDistinctPoints(g_positions);
  }

  private static Integer[] findCurrentPosition() {
    Set<Character> possible_direftions = Set
      .of('^', 'v', '>', '<');
    Integer position[] = {0,0};

    for (int h=0; h<map.size(); h++) {
      for (int w=0; w<map.get(h).length(); w++) {
        boolean isGuard = possible_direftions
          .contains(map.get(h).charAt(w));
        if (isGuard) {
          position[0] = w;
          position[1] = h;
        }
      }
    }
    return position;
  }

  private static void updateMapLine(
    char new_state, Integer[] pos) {
    StringBuilder b = new StringBuilder(
      map.get(pos[1]));
    
    b.setCharAt(pos[0], new_state);    
    map.set(pos[1], b.toString());
  }

  private static char rotateDirection(char guard) {
    switch (guard) {
      case '>':
        return 'v';
      case 'v':
        return '<';
      case '<':
        return '^';
      case '^':
      default:
        return '>';
    }
  }
  private static boolean hasExitedMap (Integer[] pos) {
    boolean result = (pos[0]-1<0) ||
      (pos[0]+1>=map.get(0).length()) ||
      (pos[1]+1>=map.size()) ||
      (pos[1]-1<0);
    return result;
  }

  private static Integer countDistinctPoints(
      List<Integer[]> locations) {
    Set<String> distincts = new HashSet<>();
    locations.forEach(l->{
      distincts.add(l[0] + "," + l[1]);
    });
    return distincts.size();
  }
}
