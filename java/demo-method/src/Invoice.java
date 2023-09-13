import java.util.Arrays;

public class Invoice {

  // public static double[] itemPrice(int[] quantities, double[] unitPrices) {
  // double[] itemPrice = new double[quantities.length];
  // for (int i = 0; i < quantities.length; i++) {
  // itemPrice[i] = quantities[i] * unitPrices[i];
  // }
  // return itemPrice;
  // }

  // A method to calculate item total prices for an item
  public static double calcTotalItemPrice(int quantities, double unitPrices) {
    // Early Return
    // Parameters control
    if (quantities < 0 || unitPrices < 0) {
      return 0;
    }
    return quantities * unitPrices; // main logic
  }


  // A method to calculate total amount of the invoice
  public static double calcTotalInvoiceAmount(double[] totalItemPrices) {
    double totalAmount = 0.0d;
    for (int i = 0; i < totalItemPrices.length; i++) {
      totalAmount += totalItemPrices[i];
    }
    return totalAmount;
  }


  public static void main(String[] args) {
    int[] quantities = new int[] {5, 10, 4, 7, 20};
    double[] unitPrices = new double[] {10.9, 100.3, 2.1, 9.0, 1000.3};

    double[] totalItemPrices = new double[quantities.length];
    for (int i = 0; i < totalItemPrices.length; i++) {
      totalItemPrices[i] = calcTotalItemPrice(quantities[i], unitPrices[i]);
    }
    // System.out.println(Arrays.toString(totalItemPrices));
    // Loop

    double invoiceTotalAmount = calcTotalInvoiceAmount(totalItemPrices);
    System.out.println("Total Amount=" + invoiceTotalAmount);


  }

}
