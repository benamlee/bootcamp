package order;

import java.util.Arrays;

public class ItemDesc {
  private String header;
  private String body;

  public ItemDesc(String header, String body) {
    this.header = header;
    this.body = body;
  }

  public static void main(String[] args) {
    ItemDesc itemA = new ItemDesc("Item A", "90% discount, just for today");
    ItemDesc itemB = new ItemDesc("Item B", "70% discount, just for this week");
    Transaction t = new Transaction(1, itemA, 3, 10.5d);
    Transaction t2 = new Transaction(1, itemB, 4, 20.5d);
    Order order = new Order(new Transaction[] {t, t2});

    
    System.out.println(Arrays.toString(order.getSubtotal()));
    System.out.println(order.getTotal());


  }
}
