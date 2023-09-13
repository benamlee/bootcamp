public class ReverseString {
  public static void main(String[] args) {
    String str = "hello";
    // output: olleh
    // str.charAt()
    String str2 = "";
    for (int i = 0; i < str.length(); i++) {
      // System.out.print(str.charAt(str.length() - i - 1));
      str2 += str.charAt(str.length() - i - 1); // 會常用D,cos normally is not print purpose, but to be used at other substitution
      // System.out.println(str2);
    }
    System.out.println("try1"+str2);

    String reversed = "";
    for (int i = str.length() - 1; i >= 0; i--) {
      reversed += str.charAt(i);
    }
    System.out.println("try2"+reversed);

    String rule = "";
    // rule = 1; // not the same type, error
    rule+=1;
    rule+=2;
    rule+=1; // all "1" become String
    System.out.println("try rule="+rule);


  }
}
