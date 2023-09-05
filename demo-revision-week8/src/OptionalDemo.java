import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        List<String> addresses = new ArrayList<>();
        addresses.add("Hong Kong");
        addresses.add("Mainland");
        addresses.add("Japan");
        Person8 p1 = new Person8("Ann Chan", addresses);

        List<String> addresses2 = new ArrayList<>();
        addresses2.add("Taiwan");
        addresses2.add("US");
        Person8 p2 = new Person8("Betty Chen", addresses2);

        List<Person8> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        System.out.println(getFromDb(persons, "Chan")); // true
        System.out.println(getFromDb(persons, "Lau")); // false

        Optional<Person8> result = getFromDb2(persons, "Chan");
        result.ifPresent(person -> {
            person.getAddresses().stream() //
                    .forEach(System.out::println); // lambda 寫法1
            // .forEach(addr -> { // lambda 寫法2
            // System.out.println(addr);
            // });
        });
    }

    public static Optional<Person8> getFromDb2(List<Person8> persons,
            String lastName) {
        return persons.stream() //
                .filter(p -> p.getName().endsWith(lastName)) //
                .findAny() // Optional<Person8>
        ;
    }

    public static boolean getFromDb(List<Person8> persons, String lastName) {
        return persons.stream() //
                .filter(p -> p.getName().endsWith(lastName)) //
                .findAny() // Optional<Person8>
                .isPresent();
    }
}
