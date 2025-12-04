package de.joshuatoepfer.day03;

import org.junit.jupiter.api.Test;

import static de.joshuatoepfer.day03.Main.getSumOfMaximalJoltageOfAllBatteryBanks;
import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

  @Test
  void getResourceFileAsString2ActiveCells() {
    assertThat(getSumOfMaximalJoltageOfAllBatteryBanks("day03/test-batterybanks.txt", 2)).isEqualTo(357);
  }

  @Test
  void getResourceFileAsString12ActiveCells() {
    assertThat(getSumOfMaximalJoltageOfAllBatteryBanks("day03/test-batterybanks.txt", 12)).isEqualTo(3121910778619L);
  }
}