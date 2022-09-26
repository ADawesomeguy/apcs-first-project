public class Main {
  public static void main(String[] args) {
    Prompt prompt = new Prompt();
    IO.clearTerm();
    try {
      IO.scrollPrint("Hello dudes! Here's a cool board:\n");
      GameBoard board = new GameBoard(5, 5);
      System.out.print(board);
      prompt.giveInitialChoices();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}