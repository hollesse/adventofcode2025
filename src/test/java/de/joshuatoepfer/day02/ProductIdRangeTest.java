package de.joshuatoepfer.day02;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ProductIdRangeTest {

  @ParameterizedTest
  @CsvSource({"11-22,11;22",
              "95-115,99",
              "998-1012,1010",
              "1188511880-1188511890,1188511885",
              "222220-222224,222222",
              "1698522-1698528,",
              "446443-446449,446446",
              "38593856-38593862,38593859",
              "565653-565659,",
              "824824821-824824827,",
              "2121212118-2121212124,"
  })
  void getInvalidProductIds(String minToMax, String expectedInvalidProductIdsString) {
    var testee = new ProductIdRange(minToMax);
    if (expectedInvalidProductIdsString != null){
      var expectedInvalidProductIds = Arrays.stream(expectedInvalidProductIdsString.split(";")).map(Long::valueOf).toList();
      assertThat(testee.getInvalidProductIds()).containsExactlyInAnyOrderElementsOf(expectedInvalidProductIds);
    } else {
      assertThat(testee.getInvalidProductIds()).isEmpty();
    }
  }


  @ParameterizedTest
  @CsvSource({"11-22,11;22",
      "95-115,99;111",
      "998-1012,999;1010",
      "1188511880-1188511890,1188511885",
      "222220-222224,222222",
      "1698522-1698528,",
      "446443-446449,446446",
      "38593856-38593862,38593859",
      "565653-565659,565656",
      "824824821-824824827,824824824",
      "2121212118-2121212124,2121212121"
  })
  void getInvalidProductIdsPart2(String minToMax, String expectedInvalidProductIdsString) {
    var testee = new ProductIdRange(minToMax);
    if (expectedInvalidProductIdsString != null){
      var expectedInvalidProductIds = Arrays.stream(expectedInvalidProductIdsString.split(";")).map(Long::valueOf).toList();
      assertThat(testee.getInvalidProductIdsPart2()).containsExactlyInAnyOrderElementsOf(expectedInvalidProductIds);
    } else {
      assertThat(testee.getInvalidProductIdsPart2()).isEmpty();
    }
  }
}