package order;

public class Order {

  private Transaction[] transactions;

  public Order(Transaction[] transactions) {
    this.transactions = transactions;
  }

  // getTotal() -> sum up subtotal
  public double[] getSubtotal() {
    double[] subtotal = new double[this.transactions.length];
    for (int i = 0; i < this.transactions.length; i++) {
      subtotal[i] = this.transactions[i].getUnitPrice()
          * this.transactions[i].getQuantity();
    }
    return subtotal;
  }

  public double getTotal() {
    double total = 0;
    for (int i = 0; i < this.transactions.length; i++) {
      total += this.getSubtotal()[i];
    }
    return total;
  }


}
