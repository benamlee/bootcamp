public class AAAAAAA {
    public static void main(String[] args) {
        // enum
        // 1. Finite number of members
        // Example 1:(Direction: up, down, left, right)
        // Example 2:(Weekday: Monday, Tuesday ...)
        // Example 3:(Doube Entry: Debit, Credit)
        // 2. Growth of enum elements (Change %)

        System.out.println(Direction.EAST); // EAST
        System.out.println(Direction.EAST.name()); // EAST , default 有 .name()

        Direction east = Direction.EAST;
        Direction east2 = Direction.EAST;
        System.out.println((east==east2)+" try");
        System.out.println(east == Direction.NORTH); // false
        System.out.println(east != Direction.NORTH); // false
        // == and != are checking the object reference


        // values() -> loop
        for (Direction d : Direction.values()) { // Direction.values() -> static method
            System.out.println(d.name());
        }

        System.out.println(Direction.SOUTH.ordinal()); // 1
        System.out.println(Direction.EAST.ordinal()); // 0

        System.out.println(east.getDegree()); // 90
        System.out.println(east.getDirection()); // E
        System.out.println(Direction.valueOf("east".toUpperCase()));
    }
}
