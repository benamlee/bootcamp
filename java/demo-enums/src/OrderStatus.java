public enum OrderStatus {

  ORDERED(0), //
  PAID(1), //
  SHIPPED(2), //
  COMPLETE(3), //
  ;

  int id;

  private OrderStatus(int id) {
    this.id = id;
  }

  public int getId() { // get method 都係 public 先有用
    return this.id;
  }

  public boolean isForward(OrderStatus status) {
    return status.getId() > this.id;
  }

  public static void main(String[] args) {
    System.out.println(OrderStatus.ORDERED.isForward(OrderStatus.PAID));
  }

}
