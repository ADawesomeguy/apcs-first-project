// Location class used to keep track of X/Y value of tiles and 
public class Location {
  // props
  private int x;
  private int y;
  
  // ctors
  public Location() {
    this.x = 0;
    this.y = 0;
  }
  
  public Location(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  // accessors 
  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }
  
  // mutators 
  public void setX(int x) {
    this.x = x;
  }
  
  public void setY(int y) {
    this.y = y;
  }
  // changes values of x and y to move player;
  public void moveLeft() {
    this.x--;
  }

  public void moveRight() {
    this.x++;
  }

  public void moveDown() {
    // down is higher y-val
    this.y++;
  }

  public void moveUp() {
    this.y--;
  }
}