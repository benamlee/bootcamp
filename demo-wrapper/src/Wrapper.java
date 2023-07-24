import javax.swing.text.html.HTMLDocument.HTMLReader.CharacterAction;

public class Wrapper { // Class
  public static void main(String[] args) {
    // Primitives: byte, short, ...
    // Wrapper Classes, corresponding primitive
    // Wrapper Class

    boolean isMale = true; // isMale is not an object
    // Wrapper Class
    Boolean isFemale = true; // isFemale is an object reference

    isMale = false;
    if (isMale) {

    }
    if (isFemale.compareTo(isMale) == 0) { // asking if isFemale with the same value of isMale
      // Boolean可以.compareTo；boolean唔得
    }
    isFemale = null; // true/ flase/ null
    // isMale = null; // cannot

    int num = 2;
    Integer num2 = 4; // num2 is an object reference
    num2 = null;

    num2 = 1000;
    String s = num2.toString(); // "1000"
    Integer i = Integer.valueOf("123"); // 123
    Integer num3 = 4;

    if (num3.compareTo(3) > 0) {
      System.out.println("num3 is > 3");
    }

    char c = 'a';
    Character c2 = 'A';
    char result = Character.toLowerCase('B'); // static method
    Character c3 = Character.valueOf('s');
    Character c4 = 's';


  }
}
