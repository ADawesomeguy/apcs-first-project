public class GameBoard {
  //variables created
  private int height;
  private int width;
  private Tile[][] grid;
  private Location loc;
  private int days;

  //Constructor GameBoard
  public GameBoard(int width, int height, Player player) {
    this.height = height;
    this.width = width;
    this.loc = new Location();
    grid = new Tile[height][width];
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        grid[y][x] = new Tile(Tile.Type.BLANK, false, new Location(x, y));
        grid[y][x].checkHasPlayer(player);
      }
    }
    this.days = 0;
  }

  public int getDays() {
    return this.days;
  }

  public void incrementDays() {
    this.days++;
  }

  public void incrementDays(int days) {
    this.days += days;
  }

  public Tile[][] getGrid() {
    return this.grid;
  }

  public void checkPlayerLocation(Player player) {
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        grid[y][x].checkHasPlayer(player);
      }
    }
  }

  public void updateAllAges() {
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        grid[y][x].incrementAge();
      }
    }
  }

  public void increaseAllAges(int time) {
    for (int y = 0; y < height; y++) {
      for (int x = 0; x < width; x++) {
        grid[y][x].incrementAge(time);
      }
    }
  }

  public Tile tileAtLocation(Location loc) {
    return grid[loc.getY()][loc.getX()];
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