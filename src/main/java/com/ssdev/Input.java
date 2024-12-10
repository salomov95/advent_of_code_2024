package com.ssdev;

import java.util.*;
import java.nio.file.*;

import java.io.IOException;

public class Input {
  final static String prefix = "src/main/resources/";
  public static List<String> getInput(
      String fileName) throws IOException {
    Path fPath = Paths.get(prefix + fileName);
    return Files.readAllLines(fPath);
  }
}
