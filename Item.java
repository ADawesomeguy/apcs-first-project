public class Item {
  // lists items
  enum Type {
    CROPS,
    FOOD,
    TOOLS,
    LIVESTOCK,
    LAND,
  }

  protected Type type;
  protected int price;

  public Item() {
    this.type = Type.CROPS;
    this.price = 100;
  }

  public Item(Type type, int price) {
    this.type = type;
    this.price = price;
  }

  // accessors
  public Type getType() {
    return this.type;
  }
  
  public int getPrice() {
    return this.price;
  }

  // modifiers
  public void setPrice(int price) {
    this.price = price;
  }

  // member methods
  public void depreciate() {
    this.price *= ((double)(Math.random() * 50) + 25) / 100;
    this.price = (int)this.price;
  }
  
  public String toString() {
    String ret = new String();
    String name = "";
    switch (this.type) {
      case CROPS:
        name = "Crops";
        break;
      case FOOD:
        name = "Food";
        break;
      default:
        name = "Item";
        break;
    }
    ret += name;
    ret += ": ";
    return String.format(ret + " %d₹", this.price);
  }
}