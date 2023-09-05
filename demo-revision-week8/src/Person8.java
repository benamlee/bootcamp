import java.util.List;

public class Person8 {
    private String name;
    private List<String> addresses;

    public Person8(String name, List<String> addresses) {
        this.name = name;
        this.addresses = addresses;
    }

    public String getName() {
        return this.name;
    }

    public List<String> getAddresses() {
        return this.addresses;
    }

    @Override
    public String toString() {
        return "Person(name=" + this.name //
                + ", addresses=" + this.addresses //
                + ")";
    }

}
