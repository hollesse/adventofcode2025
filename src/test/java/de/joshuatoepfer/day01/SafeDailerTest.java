package de.joshuatoepfer.day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SafeDailerTest {

  @Test
  void followInstructions() {
    var safeDail = new SafeDail(50);
    var testee = new SafeDailer("test-instructions.txt", safeDail);

    assertEquals(3, testee.followInstructions());
  }

  @Test
  void followInstructionsWithPasswordMethod0x434C49434B() {
    var safeDail = new SafeDail(50);
    var testee = new SafeDailer("test-instructions.txt", safeDail);

    assertEquals(6, testee.followInstructionsWithPasswordMethod0x434C49434B());
  }
}