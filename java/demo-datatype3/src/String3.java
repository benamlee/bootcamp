public class String3 {

  // String Literal Pool (Heap) + String is immutable
  public static void main(String[] args) {
    String str = "abc";
    String str2 = "abc";
    // *******String check 係咪一樣內容，記得用 .equals()
    System.out.println(str.equals(str2)); // true, check content 是否一樣
    System.out.println(str == str2); // true, check the address 是否一樣
    String str10 = new String("abc");
    System.out.println();
    System.out.println(str == str10); // false, content一樣, 但new左新地址，
    str10 = "abc";
    System.out.println(str == str10); // true, 又指番同一個位

    // String Literal Pool -> "abc"
    // when use " " 括號
    // 如果object一樣，address會指埋同一樣
    System.out.println();

    str = "abcde"; // str 指住新地址，str2 仍然保留原本的指針，immutable，改 str 改唔到 str2
    System.out.println("str " + str + " str2 " + str2);

    str = str2;
    System.out.println("str " + str + " str2 " + str2);
    System.out.println(str == str2); // address

    str2 = "a";
    System.out.println("str " + str + " str2 " + str2);

  }
}
