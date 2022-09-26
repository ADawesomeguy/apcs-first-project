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

  // constructors
  public Player() {
    this.name = "DaBaby";
    this.age = 47;
    this.money = 0;
    this.location = new Location();
  }

  public Player(String name, int age, int money, Location location) {
    this.name = name;
    this.age = age;
    this.money = money;
    this.location = location;
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
}