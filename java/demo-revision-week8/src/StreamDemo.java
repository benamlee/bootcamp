import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        // One Table (Person8s) -> Many Records (e.g. take data where age > 60)
        System.out.println(getFromDb("Lau").toString());
        // result: [Person8(name=Eric Lau), Person8(name=Peter Lau)]
        System.out.println(getFromDb("Chan").toString());
        // result: [Person8(name=John Chan)]

        // flatMap()
        List<String> addresses = new ArrayList<>();
        addresses.add("Hong Kong");
        addresses.add("Mainland");
        addresses.add("Japan");
        Person8 p1 = new Person8("Ann", addresses);

        List<String> addresses2 = new ArrayList<>();
        addresses2.add("Taiwan");
        addresses2.add("US");
        Person8 p2 = new Person8("Betty", addresses2);

        List<Person8> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        // return all addresses (List<String>) from List<Person>
        System.out.println(getAllAddresses(persons));
        // [Hong Kong, Mainland, Japan, Taiwan, US]

        System.out.println(getAllNames(persons));

        System.out.println(getFullNames2("Lau"));
    }

    public static List<String> getAllNames(List<Person8> persons) {
        return persons.stream() //
                .map(person -> person.getName()) //
                .collect(Collectors.toList());
    }

    public static List<String> getAllAddresses(List<Person8> persons) {
        return persons.stream() //
                .flatMap(person -> person.getAddresses().stream()) // .flatMap(list.stream())
                .collect(Collectors.toList());
    }

    public static List<String> getAllAddresses2(List<Person8> persons) {
        List<String> addresses = new ArrayList<>();
        for (Person8 p : persons) {
            for (String s : p.getAddresses()) { // flatMap
                addresses.add(s);
            }
        }
        return addresses;
    }

    public static List<List<String>> getAllAddresses22(List<Person8> persons) {
        // List<List<String>> addressLists = new ArrayList<>();
        // for (Person8 p : persons) {
        // addressLists.add(p.getAddresses());
        // } // list of list
        // return addressLists;

        return persons.stream() // list of list
                .map(person -> person.getAddresses()) // 用map會collect list of list
                .collect(Collectors.toList());
    }

    public static List<String> getFullNames(String lastName) {
        // Call Database, and returned a List of Person8
        // SQL -> filter by lastname (where last_name = lastName)
        List<Person9> persons = new ArrayList<>();
        persons.add(new Person9("John Chan"));
        persons.add(new Person9("Eric Lau"));
        persons.add(new Person9("Peter Lau"));
        // Stream, last name = Lau
        return persons.stream() //
                .filter(p -> p.getName().endsWith(lastName)) // p means T (T -> Person8)
                .map(p -> {
                    return p.getName(); // Conversion: from List<Person8> to List<String>
                }).collect(Collectors.toList());
    }

    public static List<String> getFullNames2(String lastName) {
        List<Person9> persons = new ArrayList<>();
        persons.add(new Person9("John Chan"));
        persons.add(new Person9("Eric Lau"));
        persons.add(new Person9("Peter Lau"));
        List<String> names = new ArrayList<>();
        for (Person9 p : persons) {
            if (p.getName().endsWith(lastName))
                names.add(p.getName());
        }
        return names;
    }

    public static List<Person9> getFromDb(String lastName) {
        // Call Database, and returned a List of Person8
        // SQL -> filter by lastname (where last_name = lastName)
        List<Person9> persons = new ArrayList<>();
        persons.add(new Person9("John Chan"));
        persons.add(new Person9("Eric Lau"));
        persons.add(new Person9("Peter Lau"));
        // Stream, last name = Lau
        return persons.stream() //
                .filter(e -> e.getName().endsWith(lastName)) //
                .collect(Collectors.toList());

    }
}
