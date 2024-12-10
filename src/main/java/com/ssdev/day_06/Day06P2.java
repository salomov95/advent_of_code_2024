package com.ssdev.day_06;

import java.util.*;
import java.io.IOException;
import java.util.stream.Collectors;

public class Day06P2 {
  private final static List<Character> DIRECTIONS = List.of('^','v','>','<');
  private static List<String> map;
  private static int loop_count = 0;

  public static Integer run() throws IOException {
    map = Day06Input.getInput();
    var g_route = guardRoutes();

    for (int r=1; r<g_route.size(); r++) {
      // Reset Map
      map = Day06Input.getInput();
      var route = g_route.get(r);
      var start_pos = g_route.get(0);
      var not_at_start = (route[0]!=start_pos[0]) &&
                         (route[1]!=start_pos[1]);
      // Insert Obstacle
      if (not_at_start) {
        updateMapLine('#', route);
      }
      // Checks Loop
      if (findLoop()) loop_count++;
    };

    return loop_count;
  }

  private static boolean findLoop() {
    List<Integer[]> g_positions = new ArrayList<>();
    g_positions.add(findCurrentPosition());
    boolean is_looping = false;

    while (true) {
      Integer curr_pos[] = g_positions
        .get(g_positions.size()-1);

      if (hasExitedMap(curr_pos)) {
        is_looping = false;
        break;
      }

      Integer next_step[] = {0,0,0};
      char direction = map.get(curr_pos[1])
        .charAt(curr_pos[0]);

      switch (direction) {
        case '>':
          next_step[0] = curr_pos[0]+1;
          next_step[1] = curr_pos[1];
          next_step[2] = 1;
          break;
        case 'v':
          next_step[0] = curr_pos[0];
          next_step[1] = curr_pos[1]+1;
          next_step[2] = 3;
          break;
        case '<':
          next_step[0] = curr_pos[0]-1;
          next_step[1] = curr_pos[1];
          next_step[2] = 0;
          break;
        case '^':
        default:
          next_step[0] = curr_pos[0];
          next_step[1] = curr_pos[1]-1;
          next_step[2] = 2;
          break;
      }

      var next_pos = map.get(next_step[1])
        .charAt(next_step[0]);

      var route_rpt = g_positions.stream().filter(p->(
        (p[0]==curr_pos[0]) &&
        (p[1]==curr_pos[1]) &&
        (p[2]==curr_pos[2])
      )).collect(Collectors.toList());

      if (route_rpt.size()>=3) {
        is_looping = true;
        break;
      }

      if (next_pos == '#') {
        char new_direction = rotateDirection(direction);
        updateMapLine(new_direction, curr_pos);
      } else {
        g_positions.add(next_step);
        updateMapLine('.', curr_pos);
        updateMapLine(direction, next_step);
      }
    }

    return is_looping;
  }

  private static List<Integer[]> guardRoutes() {
    List<Integer[]> g_positions = new ArrayList<>();

    // Position Shape {x_axis, y_axis, DIRECTION}
    g_positions.add(findCurrentPosition());

    while (true) {
      Integer curr_pos[] = g_positions
        .get(g_positions.size()-1);

      if (hasExitedMap(curr_pos)) break;

      char direction = map.get(curr_pos[1])
        .charAt(curr_pos[0]);

      Integer next_step[] = {0,0,0};
      
      switch (direction) {
        case '>':
          next_step[0] = curr_pos[0]+1;
          next_step[1] = curr_pos[1];
          next_step[2] = 1;
          break;
        case 'v':
          next_step[0] = curr_pos[0];
          next_step[1] = curr_pos[1]+1;
          next_step[2] = 3;
          break;
        case '<':
          next_step[0] = curr_pos[0]-1;
          next_step[1] = curr_pos[1];
          next_step[2] = 0;
          break;
        case '^':
        default:
          next_step[0] = curr_pos[0];
          next_step[1] = curr_pos[1]-1;
          next_step[2] = 2;
          break;
      }

      var next_pos = map
        .get(next_step[1])
        .charAt(next_step[0]);

      if (next_pos == '#') {
        char new_direction = rotateDirection(
          direction);
        updateMapLine(new_direction, curr_pos);
      } else {
        g_positions.add(next_step);
        updateMapLine('.', curr_pos);
        updateMapLine(direction, next_step);
      }
    }

    return g_positions;
  }

  private static Integer[] findCurrentPosition() {
    Integer position[] = {0,0,0};


    for (int h=0; h<map.size(); h++) {
      for (int w=0; w<map.get(h).length(); w++) {
        var direction = map.get(h).charAt(w);
        boolean is_guard = DIRECTIONS.contains(direction);

        if (is_guard) {
          position[0] = w;
          position[1] = h;
          position[2] = DIRECTIONS.indexOf(direction);
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
  private static boolean hasExitedMap(Integer[] pos) {
    boolean result = (pos[0]-1<0) ||
      (pos[0]+1>=map.get(0).length()) ||
      (pos[1]+1>=map.size()) ||
      (pos[1]-1<0);
    return result;
  }
}
