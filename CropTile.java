public class CropTile extends Tile {
  enum Status {
    SEEDLING,
    HARVESTABLE,
    DEAD
  }
  
  // constructors
  public CropTile() {
    this.type = Type.CROP;
    this.hasPlayer = false;
    this.location = new Location();
    this.age = 0;
  }

  public CropTile(Type type, boolean hasPlayer, Location location) {
    super(type, hasPlayer, location, 0);
  }

  // methods
  public boolean harvest() {
    if (age > ((int)(Math.random() * 5) + 5)) {
      return true;
    } else {
      return false;
    }
  }
}