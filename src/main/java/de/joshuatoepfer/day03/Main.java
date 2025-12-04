package de.joshuatoepfer.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    System.out.println("Day 03 Sum of possible joltage with 2 active cells: " + getSumOfMaximalJoltageOfAllBatteryBanks("day03/batterybanks.txt", 2));
    System.out.println("Day 03 Sum of possible joltage with 12 active cells: " + getSumOfMaximalJoltageOfAllBatteryBanks("day03/batterybanks.txt", 12));
  }

  static long getSumOfMaximalJoltageOfAllBatteryBanks(String filename, int numberOfActiveCells) {
    try {
      return getResourceFileAsString(filename).stream()
          .map(BatteryBank::new)
          .map(bb -> bb.getMaximumJoltage(numberOfActiveCells))
          .mapToLong(Long::longValue)
          .sum();
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
