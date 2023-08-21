import java.util.ArrayList;
import java.util.List;

public class NotThatEasy {


    static final List<Character> characters = method(); // static method
    private static final char[] chars = {'J', 'a', 'c', 'k', 'y'};

    final int x = method2();

    static List<Character> method() {
        System.out.println("I am static method, called by static variable");
        return new ArrayList<>();
    }

    static int method2() { // new obj will have its int x and call this method
        System.out.println("I am static method, called by instance variable");
        return 1;
    }

    static {
        System.out.println("I am static code block");
        // characters = new ArrayList<>();
    }

    // object initialization code block
    {
        System.out.println("I am initialization code block");
    } // each time new object will do once

    public static void main(String[] args) {
        // Once you click the run button:
        // 1. Compile
        // 2. Run -> Class loader -> stack memory
        System.out.println("Start of main");
        NotThatEasy obj = new NotThatEasy();
        obj = new NotThatEasy(); // every time new obj will do, not by declare
        NotThatEasy obj3; // null will not do

    }
}
