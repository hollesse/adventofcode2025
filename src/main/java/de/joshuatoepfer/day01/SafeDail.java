package de.joshuatoepfer.day01;

public class SafeDail {


  private int actualPosition;
  private int counterPointsZeroPosition = 0;

  public int getCounterPointsOrPassedZeroPosition() {
    return counterPointsOrPassedZeroPosition;
  }

  private int counterPointsOrPassedZeroPosition = 0;

  public SafeDail(int actualPosition) {
    this.actualPosition = actualPosition;
  }

  public int getActualPosition() {
    return actualPosition;
  }

  public int getCounterPointsZeroPosition() {
    return counterPointsZeroPosition;
  }

  public int rotate(char direction, int steps) {
    if (direction == 'L') {
      var result = actualPosition - steps;
      if(actualPosition == 0 && result < 0){
        counterPointsOrPassedZeroPosition--;
      }
      while (result < 0) {
        result += 100;
        counterPointsOrPassedZeroPosition++;
      }
      actualPosition = result % 100;
    } else if (direction == 'R') {
      var result = actualPosition + steps;
      counterPointsOrPassedZeroPosition += result / 100;
      actualPosition = result % 100;
      if(actualPosition == 0){
        counterPointsOrPassedZeroPosition--;
      }
    }
    if (actualPosition == 0){
      counterPointsZeroPosition++;
      counterPointsOrPassedZeroPosition++;
    }
    return actualPosition;
  }
}
