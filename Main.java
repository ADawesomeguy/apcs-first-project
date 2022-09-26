public class Main {
  public static void main(String[] args) {
    Prompt prompt = new Prompt();
    Player player = new Player();
    GameBoard board = new GameBoard(5, 5, player);
    while (true) {
      try {
        IO.clearTerm();
        IO.scrollPrint("Hello dudes! Here's a cool board:\n");
        System.out.print(board);
        prompt.giveInitialChoices(player);
      } catch (Exception e) {
        System.out.println(e);
      }
    }
  }
}