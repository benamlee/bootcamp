public class Customer extends Human implements Orderable {

    public static int counter = 0;

    public Customer(String name) {
        super(name);
    }

    @Override
    public void order() {
        counter++;
    }

    public void humanOrder() {
        super.order();
    }
}
