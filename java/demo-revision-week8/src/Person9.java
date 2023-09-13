public class Person9 {
    private String name;


    public Person9(String name) {
        this.name = name;

    }

    public String getName() {
        return this.name;
    }



    @Override
    public String toString() {
        return "Person(name=" + this.name //
                + ")";
    }

}


