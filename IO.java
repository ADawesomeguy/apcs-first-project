import java.util.Scanner;

public class IO {
  private static final int cps = 30;
  public static void scrollPrint(String text) throws InterruptedException {
    for (char c : text.toCharArray()) {
      System.out.print(c);
      Thread.sleep(1000 / cps);
    }
  }

  public static String getStringInput(Scanner s, String[] choices) {
    boolean isInChoices = false;
    while (!isInChoices) {
      String input = s.nextLine();
      for (String choice: choices) {
        if (input.equals(choice)) {
          isInChoices = true;
          return input;
        }
      }
      if (!isInChoices) {
        System.out.println("Invalid input, please try again!");
      }
    }
    return "";
  }

  public static int getIntInput(Scanner s) {
    boolean isValidInt = false;
    while (!isValidInt) {
      try {
        int temp = s.nextInt();
        // eat newline
        s.nextLine();
        isValidInt = true;
        return temp;
      } catch (Exception e) {
        System.out.println("Invalid input, please try again!");
      }
    }
    return 0;
  }

  public static void clearTerm() {
    System.out.print("\033[H\033[2J");
  }
}