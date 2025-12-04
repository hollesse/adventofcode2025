package de.joshuatoepfer.day02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ProductIdRange {
  private long min;
  private long max;
  private List<Long> productIds = new ArrayList<>();
  private List<Long> validProductIds = new ArrayList<>();
  private List<Long> invalidProductIds = new ArrayList<>();
  private List<Long> validProductIdsPart2 = new ArrayList<>();
  private List<Long> invalidProductIdsPart2 = new ArrayList<>();


  public List<Long> getInvalidProductIds() {
    return invalidProductIds;
  }

  public List<Long> getInvalidProductIdsPart2() {
    return invalidProductIdsPart2;
  }

  public ProductIdRange(String minToMax) {
    this(Long.parseLong(minToMax.split("-")[0]), Long.parseLong(minToMax.split("-")[1]));
  }

  public ProductIdRange(long min, long max) {
    this.min = min;
    this.max = max;
    this.productIds = Stream.iterate(this.min, i -> i <= this.max, i -> i + 1).toList();
    this.validProductIds = productIds.stream().filter(this::isValid).toList();
    this.invalidProductIds = productIds.stream().filter(Predicate.not(this::isValid)).toList();
    this.validProductIdsPart2 = productIds.stream().filter(this::isValidPart2).toList();
    this.invalidProductIdsPart2 = productIds.stream().filter(Predicate.not(this::isValidPart2)).toList();
  }

  private boolean isValid(long productId) {
    var productIdString = Long.toString(productId);
    if (productIdString.length() % 2 != 0) {
      return true;
    } else {
      var firstPart = productIdString.substring(0, productIdString.length() / 2);
      var secondPart = productIdString.substring(productIdString.length() / 2);
      return !firstPart.equals(secondPart);
    }
  }

  private boolean isValidPart2(long productId) {
    var productIdString = Long.toString(productId);
    var teiler =
        Stream.iterate(productIdString.length(), i -> i > 1, i -> i - 1)
            .filter(i -> productIdString.length() % i == 0)
            .toList();
    return teiler.stream()
        .map(i -> splitIntoEqualParts(productIdString, i))
        .map(HashSet::new)
        .allMatch(set -> set.size() > 1);
  }

  private static List<String> splitIntoEqualParts(String input, int numberOfParts) {
    if (input == null || input.isEmpty() || numberOfParts <= 0) {
      throw new IllegalArgumentException("Ungültige Parameter");
    }

    int length = input.length();

    if (length % numberOfParts != 0) {
      throw new IllegalArgumentException(
          "String-Länge "
              + length
              + " lässt sich nicht gleichmäßig in "
              + numberOfParts
              + " Teile aufteilen");
    }

    int partSize = length / numberOfParts;
    List<String> parts = new ArrayList<>();

    for (int i = 0; i < numberOfParts; i++) {
      int start = i * partSize;
      int end = start + partSize;
      parts.add(input.substring(start, end));
    }

    return parts;
  }
}
