import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("start"); // Constructor
        // s -> address (reference)
        s.append(" end"); // append() is faster than "+" in String
        System.out.println(s);
        System.out.println(s.toString()); // String -> start end
        s.append(1.3f);
        System.out.println(s.toString());

        System.out.println(s.append(true).append(4000L).length());
        System.out.println(s.toString()); // start end1.3true4000

        String str = "  he llo ";
        String[] strs = str.trim().replace('h', 'e').split(" ");
        System.out.println(strs.length);
        System.out.println(Arrays.toString(strs)); // [ee, llo]

        // append
        StringBuilder s2 = new StringBuilder("start");
        System.out.println(s2.append('a').toString().charAt(3)); // r
        StringBuilder s3 = s2.append('a');
        String s4 = s3.toString();
        s4.charAt(3);
        System.out.println(s2.toString()); // startaa
        s2.append('a');
        s2.append('a');
        s2.append('a'); // 會改變到 s2
        System.out.println(s2.toString()); // startaaaaa

        // insert
        String s10 = "hello";
        StringBuilder s11 = new StringBuilder("hello");
        s11.insert(3, ' ');
        System.out.println(s11.toString()); // hel lo

        s11.insert(0, "world").append("world");
        System.out.println(s11); // worldhel loworld
        // deleteCharAt
        System.out.println(s11.deleteCharAt(3).toString()); // wordhel loworld
        System.out.println(s11);

        s11.setCharAt(4,'J'); // void
        System.out.println(s11.toString()); // wordJel loworld


    }
}
