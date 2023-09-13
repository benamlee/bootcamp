package shopping;

public abstract class Item {
  private int price;
  private String header;
  private String description;

  public Item(){}

  public Item(int price) {
    this.price = price;
  }

  public int getPrice() {
    return this.price;
  }



}
