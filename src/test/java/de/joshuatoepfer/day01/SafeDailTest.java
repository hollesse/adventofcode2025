package de.joshuatoepfer.day01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SafeDailTest {

  @ParameterizedTest
  @CsvSource({"11,R,8,19",
              "19,L,19,0",
              "0,L,1,99",
              "99,R,1,0",
              "5,L,10,95",
              "95,R,5,0",
              "0,R,100,0",
              "0,R,200,0"
  })
  void rotate(int actualPosition, char direction, int steps, int expectedPosition) {
    var testee = new SafeDail(actualPosition);
    assertEquals(expectedPosition, testee.rotate(direction, steps));
  }

  @Test
  void checkPointsOrPassedZero() {
    var actualPosition = 50;
    var testee = new SafeDail(actualPosition);

    actualPosition = testee.rotate('L', 68);
    assertEquals(82, actualPosition);
    assertEquals(1, testee.getCounterPointsOrPassedZeroPosition());

    actualPosition = testee.rotate('L', 30);
    assertEquals(52, actualPosition);
    assertEquals(1, testee.getCounterPointsOrPassedZeroPosition());

    actualPosition = testee.rotate('R', 48);
    assertEquals(0, actualPosition);
    assertEquals(2, testee.getCounterPointsOrPassedZeroPosition());

    actualPosition = testee.rotate('L', 5);
    assertEquals(95, actualPosition);
    assertEquals(2, testee.getCounterPointsOrPassedZeroPosition());

    actualPosition = testee.rotate('R', 60);
    assertEquals(55, actualPosition);
    assertEquals(3, testee.getCounterPointsOrPassedZeroPosition());

    actualPosition = testee.rotate('L', 55);
    assertEquals(0, actualPosition);
    assertEquals(4, testee.getCounterPointsOrPassedZeroPosition());

    actualPosition = testee.rotate('L', 1);
    assertEquals(99, actualPosition);
    assertEquals(4, testee.getCounterPointsOrPassedZeroPosition());

    actualPosition = testee.rotate('L', 99);
    assertEquals(0, actualPosition);
    assertEquals(5, testee.getCounterPointsOrPassedZeroPosition());

    actualPosition = testee.rotate('R', 14);
    assertEquals(14, actualPosition);
    assertEquals(5, testee.getCounterPointsOrPassedZeroPosition());

    actualPosition = testee.rotate('L', 82);
    assertEquals(32, actualPosition);
    assertEquals(6, testee.getCounterPointsOrPassedZeroPosition());

    actualPosition = testee.rotate('L', 200);
    assertEquals(32, actualPosition);
    assertEquals(8, testee.getCounterPointsOrPassedZeroPosition());

    actualPosition = testee.rotate('R', 200);
    assertEquals(32, actualPosition);
    assertEquals(10, testee.getCounterPointsOrPassedZeroPosition());
  }

  @Test
  void checkPointsOrPassedZero_hundreds() {
    var actualPosition = 50;
    var testee = new SafeDail(actualPosition);

    actualPosition = testee.rotate('L', 50);
    assertEquals(0, actualPosition);
    assertEquals(1, testee.getCounterPointsOrPassedZeroPosition());

    actualPosition = testee.rotate('L', 300);
    assertEquals(0, actualPosition);
    assertEquals(4, testee.getCounterPointsOrPassedZeroPosition());

    actualPosition = testee.rotate('R', 300);
    assertEquals(0, actualPosition);
    assertEquals(7, testee.getCounterPointsOrPassedZeroPosition());
  }
}