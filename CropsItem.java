//extends takes properties from class
public class CropsItem extends Item {
  public CropsItem() {
    super(Type.CROPS, 100);
  }

  public CropsItem(int price) {
    super(Type.CROPS, price);
  }
}