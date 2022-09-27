public class Tile {
  // crops, storage, etc.
  enum Type {
    BLANK,
    CROP, // meant to have more crops later
    STORAGE,
    LIVESTOCK
  }

  // props
  protected Type type;
  protected boolean hasPlayer;
  protected Location location;
  protected int age;

  // constructors
  public Tile() {
    this.type = Type.BLANK;
    this.hasPlayer = false;
    this.location = new Location();
    this.age = 0;
  }

  public Tile(Type type, boolean hasPlayer, Location location) {
    this.type = type;
    this.hasPlayer = hasPlayer;
    this.location = location;
    this.age = 0;
  }

  public Tile(Type type, boolean hasPlayer, Location location, int age) {
    this.type = type;
    this.hasPlayer = hasPlayer;
    this.location = location;
    this.age = age;
  }

  // accessors
  public Type getType() {
    return this.type;
  }

  public boolean getHasPlayer() {
    return this.hasPlayer;
  }

  public int getAge() {
    return this.age;
  }

  public Location getLocation() {
    return this.location;
  }

  // mutators
  public void setType(Type type) {
    this.type = type;
  }

  public void setHasPlayer(boolean hasPlayer) {
    this.hasPlayer = hasPlayer;
  }

  // member functions
  public void incrementAge() {
    this.age++;
  }

  public void incrementAge(int amt) {
    this.age += amt;
  }

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
        identifier = '+';
        break;
      default:
        identifier = ' ';
        break;
    }
    if (hasPlayer) {
      return String.format("|*%c |", identifier);
      //return String.format("|*%c%d|", identifier, age);
    } else {
      return String.format("| %c |", identifier);
      //return String.format("| %c%d|", identifier, age);
    }
  }

  public void checkHasPlayer(Player player) {
    if (player.getLocation().getX() == this.location.getX() && player.getLocation().getY() == this.location.getY()) {
      this.hasPlayer = true;
    } else {
      this.hasPlayer = false;
    }
  }

  public CropTile generateCropTile() {
    return new CropTile(Type.CROP, this.hasPlayer, this.location);
  }
}