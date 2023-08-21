public class DemoSwitch {
    // static final (constant) (0-2)
    // instance variable
    // static variable (1-2)
    // constructors
    // public instance method // main logic
    // static methods // tools
    // private methods
    public static void main(String[] args) {
        System.out.println(grade(90));
        Weekday weekday = Weekday.TUE;
        // Approach 1
        int result = switch (weekday) { // 要有野接，一定會check哂所有ENUM
            case MON, TUE -> 1;
            case WED -> 3;
            case THU -> 4;
            case FRI -> 5;
            // default -> 0; // 入ENUM 唔應該有default
        };
        System.out.println(result);
        // Approach 2
        int result2 = switch (weekday) { // 要有野接，一定會check哂所有ENUM
            case MON, TUE:
                System.out.println("Monday or Tuesday");
                yield 1; // yield means return + break
            case WED:
                System.out.println("Wednesday");
                yield 3;
            case THU:
                System.out.println("Thursday");
                yield 4;
            case FRI:
                System.out.println("Friday");
                yield 5;
        };
        System.out.println(result2);

        // in java 17 condition is not allowed in switch case
        // case type = input type
        // after java 20
        // String str = "hello world!!!";
        // String result2 = switch (str) {
        // case str.length() > 5 -> "length > 5";
        // case str.contains("world") -> "contains world";
        // default -> "a";
        // };
    }

    public static int getDayNumber(Weekday weekday) {
        switch (weekday) {
            case MON:
                return 1;
            case TUE:
                return 2;
            case WED:
                return 3;
            case THU:
                return 4;
            case FRI:
                return 5;
            default:
                return 0;
        }
    }

    public static char grade(int score) {
        char grade = ' ';
        switch (score) {
            case 90:
                grade = 'A';
                break;
            case 80:
                grade = 'B';
                break;
            default:
                grade = 'F';
        }
        return grade;
    }
}
