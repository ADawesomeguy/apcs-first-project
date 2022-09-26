public class Tile {
  // crops, storage, etc.
  enum Type {
    BLANK,
    CROP, // maybe specify different types specifically?
    STORAGE,
    LIVESTOCK
  }

  // props
  private Type type;
  private boolean hasPlayer;
  private Location location;

  // constructors
  public Tile() {
    this.type = Type.BLANK;
    this.hasPlayer = false;
    this.location = new Location();
  }

  public Tile(Type type, boolean hasPlayer, Location location) {
    this.type = type;
    this.hasPlayer = hasPlayer;
    this.location = location;
  }

  // accessors
  public Type getType() {
    return this.type;
  }
  
  public boolean getHasPlayer() {
    return this.hasPlayer;
  }

  // mutators
  public void setType(Type type) {
    this.type = type;
  }

  public void setHasPlayer(boolean hasPlayer) {
    this.hasPlayer = hasPlayer;
  }

  // member functions
  public String toString() {
    char identifier;
    switch (this.type) {
      case CROP:
        identifier = '⚘';
        break;
      case STORAGE:
        identifier = '□';
        break;
      case LIVESTOCK:
        identifier = ' ';
        break;
      default:
        identifier = ' ';
        break;
    }
    if (hasPlayer) {
      return String.format("|*%c |", identifier);
    } else {
      return String.format("| %c |", identifier);
    }
  }

  public void checkHasPlayer(Player player) {
    if (player.getLocation().getX() == this.location.getX() && player.getLocation().getY() == this.location.getY()) {
      this.hasPlayer = true;
    }
  }
}