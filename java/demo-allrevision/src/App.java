import java.util.ArrayList;
import java.util.List;

public class App {

    // 17 types
    // custom class
    // Data structures (array, list, etc)
    // Constructor (private, public, overloading, method signature, etc)
    // method (private, public, overloading, method signature, etc)
    // builder pattern
    // getter setter,

    public static void main(String[] args) throws Exception {
        List<Object> objects = new ArrayList<>();
        objects.add(new Student());
        objects.add(new Book());

        for (Object o : objects) {
            if (o instanceof Student) {
                Student s = (Student) o;
                System.out.println(s.getName());
            }
            if (o instanceof Book) {
                Book b = (Book) o;
                System.out.println(b.getHello());
            }
        }
    }
}
