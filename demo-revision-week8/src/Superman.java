import java.math.BigDecimal;

public class Superman implements Flyable {
    @Override
    public void fly() {
        System.out.println("I am flying");
    }

    static int a = 10;

    public static int add() {
        a++;
        return a;
    }

    public static double add(double a, double b) {
        return BigDecimal.valueOf(a).add(BigDecimal.valueOf(b)).doubleValue();
    }


    public static void main(String[] args) {
        // 3 ways to new a Flyable object

        // 1. Polymorphism
        Flyable superman = new Superman();
        // 2. Anonymous
        Flyable superman2 = new Flyable() {
            @Override
            public void fly() {
                System.out.println("I am Anonymois");
            }
        };
        // 3. Lambda
        Flyable superman3 = () -> System.out.println("I am Lanbda");

        superman.fly();
        superman2.fly();
        superman3.fly();
    }
}
