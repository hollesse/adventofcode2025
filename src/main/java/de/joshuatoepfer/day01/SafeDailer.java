package de.joshuatoepfer.day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class SafeDailer {

  private final List<String> instructions;
  private final SafeDail safeDail;

  public SafeDailer(String fileName, SafeDail safeDail) {
    try {
      this.instructions = getResourceFileAsString(fileName);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    this.safeDail = safeDail;
  }

  public int followInstructions() {
    instructions.forEach(
        instruction -> {
          char direction = instruction.charAt(0);
          int steps = Integer.parseInt(instruction.substring(1));
          safeDail.rotate(direction, steps);
        }
    );
    return safeDail.getCounterPointsZeroPosition();
  }

  public int followInstructionsWithPasswordMethod0x434C49434B() {
    instructions.forEach(
        instruction -> {
          char direction = instruction.charAt(0);
          int steps = Integer.parseInt(instruction.substring(1));
          safeDail.rotate(direction, steps);
        }
    );
    return safeDail.getCounterPointsOrPassedZeroPosition();
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
