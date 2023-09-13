public class Demo {
    public static void main(String[] args) throws CheckException {
        try {
            System.out.println("Hello, World!");
            throw new CheckException();
        } catch (CheckException e) {

        }
        throw new CheckException();

    }

}
