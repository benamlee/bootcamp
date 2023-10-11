@FunctionalInterface
public interface Readable {


    // abstract method (100%)
    void read();


    public static void main(String[] args) {
        Readable readable = () -> System.out.println("Hello");

        Shape shape = new Shape() {
            @Override
            public double area(){
                return 0;
            }
        }; // code block, because just let me override the method



    }

}
