import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Prompt {
  private Scanner scanner;

  public Prompt() {
    this.scanner = new Scanner(System.in);
  }

  public void giveInitialChoices(Player player, Shop shop, GameBoard board) {
    System.out.println("Please select an option:");

    ArrayList<String> initialChoices = new ArrayList<String>();
    initialChoices.add("Move");
    initialChoices.add("Shop");
    initialChoices.add("Inventory");
    initialChoices.add("Eat");
    initialChoices.add("Pass Time");

    if (board.tileAtLocation(player.getLocation()).getType() == Tile.Type.BLANK) {
      initialChoices.add("Plant");
    }

    if (board.tileAtLocation(player.getLocation()).getType() == Tile.Type.CROP) {
      initialChoices.add("Harvest");
    }

    for (int i = 0; i < initialChoices.size(); i++) {
      System.out.println("\t" + (i + 1) + ") " + initialChoices.get(i));
    }

    String initialChoiceIdx = IO.getStringInput(this.scanner,
        Arrays.toString(IntStream.rangeClosed(0, initialChoices.size()).toArray()).split("[\\[\\]]")[1].split(", "));
    String initialChoice = initialChoices.get(Integer.parseInt(initialChoiceIdx) - 1);

    System.out.println();
    switch (initialChoice) {
      case "Move":
        System.out.println("Which direction would you like to move?");
        ArrayList<String> directions = new ArrayList<String>();

        // if player is not on the left edge, add the the left movement option
        if (player.getLocation().getX() != 0) {
          directions.add("Left");
        }

        // ...
        if (player.getLocation().getX() != 4) {
          directions.add("Right");
        }

        // ...
        if (player.getLocation().getY() != 0) {
          directions.add("Up");
        }

        // ...
        if (player.getLocation().getY() != 4) {
          directions.add("Down");
        }

        for (int i = 0; i < directions.size(); i++) {
          System.out.println("\t" + (i + 1) + ") " + directions.get(i));
        }

        // create string array from integer range of choices
        // https://stackoverflow.com/questions/3619850/converting-an-int-array-to-a-string-array
        String moveChoice = IO.getStringInput(this.scanner,
            Arrays.toString(IntStream.rangeClosed(1, directions.size()).toArray()).split("[\\[\\]]")[1].split(", "));
        player.handleMovement(directions.get(Integer.parseInt(moveChoice) - 1));
        board.updateAllAges();
        break;
      case "Shop":
        System.out.println("Would you like to:");
        System.out.println("\t1) Buy");
        System.out.println("\t2) Sell");
        String buySellChoice = IO.getStringInput(this.scanner, new String[] { "1", "2" });
        switch (Integer.parseInt(buySellChoice)) {
          case 1:
            for (int i = 0; i < shop.getItems().size(); i++) {
              System.out.println("\t" + (i + 1) + ") " + shop.getItems().get(i));
            }
            System.out.println();
            System.out.println("Would you like to buy anything? (0 for nothing)");
            String purchaseChoice = IO.getStringInput(this.scanner,
                Arrays.toString(IntStream.rangeClosed(0, shop.getItems().size()).toArray()).split("[\\[\\]]")[1]
                    .split(", "));

            switch (purchaseChoice) {
              case "0":
                break;
              default:
                shop.purchase(player, Integer.parseInt(purchaseChoice) - 1);
                break;
            }
            break;
          case 2:
            for (int i = 0; i < player.getInventory().length; i++) {
              System.out.println("\t" + (i + 1) + ") " + player.getInventory()[i]);
            }
            System.out.println();
            System.out.println("Would you like to sell anything? (0 for nothing)");
            String sellChoice = IO.getStringInput(this.scanner,
                Arrays.toString(IntStream.rangeClosed(0, player.getInventory().length).toArray()).split("[\\[\\]]")[1]
                    .split(", "));

            switch (sellChoice) {
              case "0":
                break;
              default:
                shop.sell(player, Integer.parseInt(sellChoice) - 1);
                break;
            }
            break;
        }
        break;
      case "Inventory":
        for (int i = 0; i < player.getInventory().length; i++) {
          System.out.println("\t" + (i + 1) + ") " + player.getInventory()[i]);
        }
        // wait for ENTER
        System.out.println("Press ENTER to continue");
        scanner.nextLine();
        break;

      case "Plant":
        // check if player has crops
        boolean hasCrops = false;
        for (Item item : player.getInventory()) {
          if (item.getType() == Item.Type.CROPS) {
            hasCrops = true;
          }
        }

        if (!hasCrops) {
          System.out.println("You don't have any crops to plant!");
          // wait for ENTER
          System.out.println("Press ENTER to continue");
          scanner.nextLine();
        } else {
          // converting the tile to a crop tile
          board.getGrid()[player.getLocation().getY()][player.getLocation().getX()] = board
              .tileAtLocation(player.getLocation()).generateCropTile();
          player.removeCropFromInventory();
        }
        board.updateAllAges();
        break;

      case "Harvest":
        // System.out.printf("tile location: (%d, %d), tile age: %d\n",
        // board.tileAtLocation(player.getLocation()).getLocation().getX(),
        // board.tileAtLocation(player.getLocation()).getLocation().getY(),
        // board.tileAtLocation(player.getLocation()).getAge());
        if (board.tileAtLocation(player.getLocation()).getAge() > ((int) (Math.random() * 5) + 5)) {
          final String[] foods = new String[] { "Chicken Tikka Masala", "Gobi Manchurian", "Kaju Katli" };
          System.out.printf("Congratulations, the %s successfully harvested and is now in your inventory as food!\n",
              foods[(int)(Math.random() * 3)]);
          player.addToInventory(new Item(Item.Type.FOOD, (int) (Math.random() * 50) + 50));
        } else {
          System.out.println("Uh-oh! You tried to harvest too early and the plant was not yet ready.");
        }
        board.getGrid()[player.getLocation().getY()][player.getLocation().getX()] = new Tile();
        // wait for ENTER
        System.out.println("Press ENTER to continue");
        scanner.nextLine();

        board.updateAllAges();
        break;

      case "Eat":
        boolean hasFood = false;
        for (Item item : player.getInventory()) {
          if (item.getType() == Item.Type.FOOD) {
            hasFood = true;
          }
        }

        if (!hasFood) {
          System.out.println("You don't have any food to eat!");
          // wait for ENTER
          System.out.println("Press ENTER to continue");
          scanner.nextLine();
        } else {
          player.removeFoodFromInventory();
          player.setSustenance(100);
        }
        break;

      case "Pass Time":
        System.out.println("How much time would you like to pass?");
        int timeToPass = IO.getIntInput(scanner);
        board.increaseAllAges(timeToPass);
        board.incrementDays(timeToPass);
        player.setSustenance(player.getSustenance() - (int) (Math.random() * 10 * timeToPass));
    }
  }
}