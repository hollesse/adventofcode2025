package de.joshuatoepfer.day01;

public class Main {
  public static void main(String[] args) {
    var safeDail1 = new SafeDail(50);
    var safeDailer1 = new SafeDailer("instructions.txt", safeDail1);
    var safeDail2 = new SafeDail(50);
    var safeDailer2 = new SafeDailer("instructions.txt", safeDail2);

    System.out.println("Password: " + safeDailer1.followInstructions());
    System.out.println("Password with password method 0x434C49434B: " + safeDailer2.followInstructionsWithPasswordMethod0x434C49434B());
  }
}