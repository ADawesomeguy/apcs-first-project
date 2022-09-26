import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Prompt {
  private Scanner scanner;

  public Prompt() {
    this.scanner = new Scanner(System.in);
  }

  public void giveInitialChoices(Player player) {
    System.out.println("Please select an option:");
    System.out.println("\t1) Move");
    String initialChoice = IO.getStringInput(this.scanner, new String[] {"1", "2", "3", "4"});
    switch (initialChoice){
      case "1":
        System.out.println("Which direction would you like to move?");
        ArrayList<String> directions = new ArrayList<String>();

        // if player is not on the left edge, add the the left movement option
        if (player.getLocation().getX() != 0) {
          directions.add("Left");
        }

        // ...
        if (player.getLocation().getX() != 4){
          directions.add("Right");
        }

        // ...
        if (player.getLocation().getY() !=0) {
          directions.add("Up");
        }

        // ...
        if (player.getLocation().getY() !=4) {
          directions.add("Down");
        }

        for (int i = 0; i < directions.size(); i++) {
          System.out.println((i + 1) + ") " + directions.get(i));
        }

        // create string array from integer range of choices
        // https://stackoverflow.com/questions/3619850/converting-an-int-array-to-a-string-array
        String moveChoice = IO.getStringInput(this.scanner, Arrays.toString(IntStream.rangeClosed(1, directions.size()).toArray()).split("[\\[\\]]")[1].split(", "));
        break;
      case "2":
        break;
      case "3":
        break;
      case "4":
        break;
    }
  }
}