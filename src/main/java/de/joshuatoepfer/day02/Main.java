package de.joshuatoepfer.day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    System.out.println("Day 02 Sum of invalid product ids: " + getSumOfInvalidProductIds("day02/ranges.txt"));
    System.out.println("Day 02 Sum of invalid product ids part 2: " + getSumOfInvalidProductIdsPart2("day02/ranges.txt"));
  }

  public static long getSumOfInvalidProductIds(String filename) {
    try {
      var ranges =
          Arrays.stream(getResourceFileAsString(filename).getFirst().split(","))
              .map(ProductIdRange::new)
              .toList();
      var invalidProductIds = ranges.stream().flatMap(r -> r.getInvalidProductIds().stream()).toList();
      return invalidProductIds.stream().mapToLong(Long::longValue).sum();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public static long getSumOfInvalidProductIdsPart2(String filename) {
    try {
      var ranges =
          Arrays.stream(getResourceFileAsString(filename).getFirst().split(","))
              .map(ProductIdRange::new)
              .toList();
      var invalidProductIds = ranges.stream().flatMap(r -> r.getInvalidProductIdsPart2().stream()).toList();
      return invalidProductIds.stream().mapToLong(Long::longValue).sum();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  static List<String> getResourceFileAsString(String fileName) throws IOException {
    ClassLoader classLoader = ClassLoader.getSystemClassLoader();
    try (InputStream is = classLoader.getResourceAsStream(fileName)) {
      if (is == null) return null;
      try (InputStreamReader isr = new InputStreamReader(is);
          BufferedReader reader = new BufferedReader(isr)) {
        return reader.lines().toList();
      }
    }
  }
}
