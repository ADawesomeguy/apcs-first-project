import java.util.Scanner;
import java.util.ArrayList;

public class Prompt {
  //private int choiceLoc;
  //private int choiceStat;
  private Scanner scanner;

  public Prompt() {
    this.scanner = new Scanner(System.in);
  }

  public void giveInitialChoices() {
    System.out.println("Please select an option:");
    System.out.println("\t1) Move");
    String initialChoice = IO.getStringInput(this.scanner, new String[] {"1", "2", "3", "4"});
    switch (initialChoice){
      case "1":
        System.out.println("Which direction would you like to move?");
        ArrayList<String> directions = new ArrayList<String>();

        directions.add("")
        
        String moveChoice = IO.getStringInput(this.scanner, /*new String[] {"1", "2", "3", "4"}*/);
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