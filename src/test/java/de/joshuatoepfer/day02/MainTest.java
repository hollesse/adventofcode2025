package de.joshuatoepfer.day02;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

  @Test
  void getSumOfInvalidProductIds() {
    assertThat(Main.getSumOfInvalidProductIds("day02/test-ranges.txt")).isEqualTo(1227775554L);
  }

  @Test
  void getSumOfInvalidProductIdsPart2() {
    assertThat(Main.getSumOfInvalidProductIdsPart2("day02/test-ranges.txt")).isEqualTo(4174379265L);
  }
}
