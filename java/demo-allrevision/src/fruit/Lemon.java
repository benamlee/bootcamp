package fruit;

public class Lemon {

    protected String name;

    protected String greeting() {
        return "hello";
      }

    public static void main(String[] args) {
        Lemon l = new Lemon();
        l.name = "a";
    }
}
