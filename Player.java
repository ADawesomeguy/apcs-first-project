import java.util.ArrayList;

public class Player {
  enum Status {
    NEUTRAL,
    HUNGRY, 
    HAPPY, 
    DYSENTRY,
  }
  
  // props
  private String name;
  private int age;
  private int money;
  private Status status;
  private Location location;
  private ArrayList<Item> inventory;
  private int sustenance;

  // constructors
  public Player() {
    this.name = "DaBaby";
    this.age = 47;
    this.money = 300;
    this.location = new Location();
    this.inventory = new ArrayList<Item>();
    this.sustenance = 100;
  }

  public Player(String name, int age, int money, Location location, int sustenance) {
    this.name = name;
    this.age = age;
    this.money = money;
    this.location = location;
    this.inventory = new ArrayList<Item>();
    this.sustenance = sustenance;
  }

  // accessors
  public String getName() {
    return this.name;
  }

  public int getAge() {
    return this.age;
  }

  public int getMoney() {
    return this.money;
  }

  public Status getStatus() {
    return this.status;
  }

  public Location getLocation() {
    return this.location;
  }

  public int getSustenance() {
    return this.sustenance;
  }

  public Item[] getInventory() {
    // need to add empty array to specify type:
    // https://stackoverflow.com/questions/9572795/convert-list-to-array-in-java
    // join discord or ft? ft
    return this.inventory.toArray(new Item[0]);
  }

  // mutators
  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public void setSustenance(int sustenance) {
    this.sustenance = sustenance;
  }
  
  public void handleMovement(String direction) {
    switch (direction) {
      case "Left":
        this.location.moveLeft();
        break;
      case "Right":
        this.location.moveRight();
        break;
      case "Down":
        this.location.moveDown();
        break;
      case "Up":
        this.location.moveUp();
        break;
    }
    System.out.println("New location: " + this.location.getX() + ", " + this.location.getY());
  }

  public void removeItemOfTypeFromInventory(Item.Type type) {
    for (int i = 0; i < this.inventory.size(); i++) {
      if (this.inventory.get(i).getType() == type) {
        this.inventory.remove(i);
        return;
      }
    }
  }
  
  public void removeCropFromInventory() {
    removeItemOfTypeFromInventory(Item.Type.CROPS);
  }
  
  public void removeFoodFromInventory() {
    removeItemOfTypeFromInventory(Item.Type.FOOD);
  }
  
  public void addToInventory(Item item) {
    this.inventory.add(item);
  }
}