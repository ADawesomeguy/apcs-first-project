import java.util.ArrayList;

// shop code
class Shop {
  ArrayList<Item> items;

  public Shop() {
    items = new ArrayList<Item>();

    // add random items on shop creation
    // TEST: start with crops
    for (int i = 0; i < 3; i++) {
      items.add(new CropsItem());
    }
  }

  // accessors
  public ArrayList<Item> getItems() {
    return this.items;
  }

  // member functions
  public void purchase(Player player, int itemIdx) {
    player.setMoney(player.getMoney() - items.get(itemIdx).getPrice());
    items.get(itemIdx).depreciate();
    player.addToInventory(items.get(itemIdx));
    this.items.remove(itemIdx);
  }

  public void sell(Player player, int itemIdx) {
    player.setMoney(player.getMoney() + player.getInventory()[itemIdx].getPrice());
  }
}