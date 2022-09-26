public class GameBoard {
  private int height;
  private int width;
  private Tile[][] grid;
  private Location loc;
  private Player player;

  public GameBoard(int width, int height) {
    this.height = height;
    this.width = width;
    this.loc = new Location();
    this.player = new Player();
    grid = new Tile[height][width];
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        grid[y][x] = new Tile(Tile.Type.BLANK, false, new Location(x, y));
        grid[y][x].checkHasPlayer(player);
      }
    }
  }

  public String toString() {
    String ret = "";
    ret += new String(new char[this.width]).replace("\0", "-----");
    ret += '\n';
    for (Tile[] row : grid) {
      for (Tile col : row) {
        //ret += col.toString();
        ret += col.toString();
      }
      ret += '\n';
      ret += new String(new char[this.width]).replace("\0", "-----");
      ret += '\n';
    }
    return ret;
  }
}