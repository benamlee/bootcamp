public class Student {

    int age;

    private String name = "abc"; // this is object
    // class loading 已經產生了 "abc" , ready for use
    // before new Student, "abc" is already exist

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static void main(String[] args) {
        // String name = "Hello"; // this is no relation with the class attribute
        // the attribute name is follow Student object

        Student s1 = new Student();
        Student s2 = new Student(); // here 3 object in heap

        System.out.println(s1.name == s2.name); // true, address is same

        s2.setName("abcd"); // here 4 object



    }

}
