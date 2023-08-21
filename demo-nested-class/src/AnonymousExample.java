interface Reading {
    void read();
}


public class AnonymousExample {
    public static void main(String[] args) {
        Reading read1 = () -> {
            System.out.println("i am lambda, reading...");
        };
        read1.read();

        Reading read2 = new Reading() {
            int x;

            @Override
            public void read() {
                this.x++;
                System.out.println("i am Anonymous, reading... x=" + x);
            }
        };
        read2.read();
        read1.read();

    }
}
