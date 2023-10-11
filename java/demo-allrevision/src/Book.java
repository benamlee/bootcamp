public class Book {
    // 17 types
    // custom class
    // Data structures (array, list, etc)
    // Constructor (private, public, overloading, method signature, etc)
    // method (private, public, overloading, method signature, etc)
    // builder pattern
    // getter setter, lombok, toString

    public String getHello() {
        return "hello";
    }

    public static void main(String[] args) {
        Object x = "123"; // "123" is Object
        if (x instanceof String) {
            System.out.println("it is string");
        }

        x = 123; // 123 is Integer Object
        if (x instanceof Integer) {
            System.out.println("it is integer");
        }


        Object y = new Square(7);
        Shape s = new Square(9);
        Square t = new Square(4);

        if (s instanceof Square) {
            System.out.println("s is a square");
        }

        if (y instanceof Square) {
            System.out.println("y is a square");
        }

        if (t instanceof Shape) {
            System.out.println("t instanceof shape");
        }
    }

}
