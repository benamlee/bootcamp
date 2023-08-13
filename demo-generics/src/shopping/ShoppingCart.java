package shopping;

import java.util.ArrayList;

public class ShoppingCart { // 範圍已限制所有instance method 的 T

  private ArrayList<CheckoutItem> items;

  public ShoppingCart() {
    items = new ArrayList<>();
  }

  public int totalAmount() {
    int sum = 0;
    for (CheckoutItem item : this.items) {
      sum += Math.max(0, item.getPrice()) * Math.max(0, item.getQuantity());
    }
    return sum;
  }

  public void add(int quantity, DisplayItem displayItem) { // Food
    // items.add(item);
    // construct CheckoutItem
    CheckoutItem checkoutItem =
        new CheckoutItem(quantity, displayItem.getPrice());
    items.add(checkoutItem);
  }

  public boolean remove(CheckoutItem item) {
    return items.remove(item);
  }

  public void clear(){
    this.items.clear();
  }

  public static void main(String[] args) {
    ShoppingCart cart = new ShoppingCart();
    // cart.add(new Rice());
    // cart.add(new Food()) // Food is abstract
    // ShoppingCart<Drink> cart2 = new ShoppingCart<>();
    // ShoppingCart<Food> cart3 = new ShoppingCart<>();
    // ShoppingCart<Rice> cart4 = new ShoppingCart<>();
    // // ShoppingCart<Object> cart5 = new ShoppingCart<>();

  }

}
