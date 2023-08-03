public class Demo {
    public static void main(String[] args) {
        // Dynamic Polymorphism (Run-time)
        Building building = new House(); // Object is Building, but it 指針是 House
        // Compile-time checks
        // building.getCapacity(); // compile error
        building.print(); // Compile-time confirm you can call print() method
        // I am House
        // Run-time decide which print() is going to call
        // So, "building" variable call House's print() method
        building.print2(); // this.print(), "this" is still 指針 House
        // I am House
        // building.buildingPrint(); // Object 係 Building, so 用不到 House method

        // Static Polymorphism (Compile-time)
        // Method Signature (method name + parameters)
        House house = new House();
        house.print("hello");
        house.print();
        House house2 = new House(3.0d);
        house2.print("hhh");
        house2.print();
        // House house3 = new House("hello"); // The constructor House(String) is undefined
        // house2.print(3L); // .print(long) not found

        // downcast
        long l1 = Long.valueOf(1L); // i.e. (long)Long.valueOf(1L) , cos it's wrapper class, so it unbox
        Long l3 = 3L; // wrapper class -> auto-box
        long l2 = 2; // upcasting
        int i2 = (int) 3L; // downcast

        Object obj = new Container();
        if (obj instanceof Cube) { // false , container 唔會有哂 cube 獨有的野
            Cube cube = (Cube) obj; // downcast: Object -> Cube
            System.out.println("obj is instance of Cube");
        }

        Object obj2 = new Cube();
        if (obj2 instanceof Container) { // true , cube 繼承哂 container 所有野
            Container container = (Container) obj2; // downcast: Object -> Container
            System.out.println("obj2 is instance of Container");
        }

        Object obj3 = new Cone();
        // Cube cube2 = (Cube) obj3; // java.lang.ClassCastException
        // runtime exception: Run-time polymorphism

        Number number = Integer.valueOf(3);
        // Double d1 = (Double) number; // 兄弟姐妹 class

    }
}
