package de.joshuatoepfer.day03;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
class BatteryBankTest {

  @ParameterizedTest
  @CsvSource({"987654321111111,98",
              "811111111111119,89",
              "234234234234278,78",
              "818181911112111,92"
  })
  void getMaximumJoltage(String batteryCellsString, long maximumJoltage) {
    var testee = new BatteryBank(batteryCellsString);
    assertThat(testee.getMaximumJoltage()).isEqualTo(maximumJoltage);
  }

  @ParameterizedTest
  @CsvSource({"987654321111111,987654321111",
      "811111111111119,811111111119",
      "234234234234278,434234234278",
      "818181911112111,888911112111"
  })
  void getMaximumJoltage12ActiveCells(String batteryCellsString, long maximumJoltage) {
    var testee = new BatteryBank(batteryCellsString);
    assertThat(testee.getMaximumJoltage(12)).isEqualTo(maximumJoltage);
  }

  @ParameterizedTest
  @CsvSource({"987654321111111,987",
      "811111111111119,819",
      "234234234234278,478",
      "818181911112111,921"
  })
  void getMaximumJoltage3ActiveCells(String batteryCellsString, long maximumJoltage) {
    var testee = new BatteryBank(batteryCellsString);
    assertThat(testee.getMaximumJoltage(3)).isEqualTo(maximumJoltage);
  }
}