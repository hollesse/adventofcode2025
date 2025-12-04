package de.joshuatoepfer.day03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BatteryBank {

  private List<Integer> batteryCells;

  public BatteryBank(String batteryCellsString) {
    this.batteryCells = batteryCellsString.chars()
        .map(c -> c - '0')
        .boxed()
        .toList();
  }

  public long getMaximumJoltage() {
    return getMaximumJoltage(2);
  }

  public long getMaximumJoltage(int numberOfActiveCells) {
    List<BatteryCell> activeBatteryCells = new ArrayList<>();
    for (int i = 0; i < numberOfActiveCells; i++) {
      var startIndex = activeBatteryCells.isEmpty() ? 0 : activeBatteryCells.getLast().index + 1;
      var batteryCellsToChose = batteryCells.subList(startIndex, batteryCells.size() - numberOfActiveCells + 1 + activeBatteryCells.size());
      var joltage = batteryCellsToChose.stream().max(Integer::compareTo).orElseThrow();
      var index = batteryCellsToChose.indexOf(joltage) + startIndex;
      activeBatteryCells.add(new BatteryCell(joltage, index));
    }
    return Long.parseLong(activeBatteryCells.stream().map(BatteryCell::joltage).map(Long::toString).collect(Collectors.joining()));
  }

  private record BatteryCell(int joltage, int index) {

  }

//  public long getMaximumJoltage(int numberOfActiveCells) {
//    var batteryCellsWithoutLast = batteryCells.subList(0, batteryCells.size() - 1);
//    var firstNumber = batteryCellsWithoutLast.stream().max(Integer::compareTo).orElseThrow();
//    var firstNumberIndex = batteryCells.indexOf(firstNumber);
//
//    var batteryCellsStartingAtFirstNumber = batteryCells.subList(firstNumberIndex + 1, batteryCells.size());
//    var secondNumber = batteryCellsStartingAtFirstNumber.stream().max(Integer::compareTo).orElseThrow();
//    return Long.parseLong(firstNumber.toString() + secondNumber.toString());
//  }
}
