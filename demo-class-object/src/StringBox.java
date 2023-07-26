import java.util.Arrays;

public class StringBox { // Class
  private String string; // String -> Class

  public StringBox() {}

  public StringBox(String string) {
    if (string == null) // 有人new null 都比個 ""， 下面就唔洗 check null
      this.string = ""; // 因為 null 唔可以 .method
    this.string = string;
  }

  public void setString(String string) {
    this.string = string;
  }

  public String getString() {
    return this.string;
  }

  public StringBox append(String str) { // return type -> 變番自己 Class
    // return this.string + str; // 呢個寫法不影響本身的 this.string
    if (str == null || "".equals(str))
      return this;
    this.string = this.string + str;
    // return this.string; // 呢個寫法就會改寫
    return this; // 出番自己
  }

  public static StringBox append(String str, String str2) {
    return new StringBox(str + str2); // create an object of StringBox by constructor
  } // StringBox -> 黃色 Class ， 藍色 Constructor

  public String toString() { // JAVA 自動行埋
    return this.string;
  }

  /**
   * 
   * @param idx Range
   * @param s The string to be inserted
   * @return Object of StringBox
   */
  public StringBox insert(int idx, String s) {
    if (idx < 0 || idx > this.string.length()) {
      return this;
    }
    if (s == null || "".equals(s)) {
      return this;
    }
    this.string =
        this.string.substring(0, idx) + s + this.string.substring(idx);
    return this;
  }

  public static void main(String[] args) {
    StringBox s = new StringBox();
    s.setString("Java");
    System.out.println(s.append("Python")); // 改左 return type ，變左address
    System.out.println(s.append("Javascript").append("HTML")); // return this 才可以 .append() 兩次，都係地址
    // System.out.println(s.toString());

    String str1 = null; // 冇針
    String str2 = "aa";
    if (str2.equals(str1)) {
      System.out.println("abc");
    } else {
      System.out.println("cba");
    }
    // if (str1.equals(str2)) { // null冇針，唔可以用 .equals()
    // System.out.println("abc");
    // } else {
    // System.out.println("cba");
    // }
    if (str1 != null && str1.equals(str2)) {
      System.out.println("good");
    }

    String s3 = StringBox.append("hello", "woo").toString(); // 這 class 的 static method 做一個 StringBox 去用 .toString()
    System.out.println(s3);

    //pass by value
    String s1 = "a";
    String s2 = s1;
    System.out.println(s2);
    s1 = "b";
    System.out.println(s2);
    // pass by reference
    char[] arr1 = new char[] {'a'};
    char[] arr2 = arr1;
    System.out.println(Arrays.toString(arr2));
    arr1[0] = 'b';
    System.out.println(Arrays.toString(arr2));
  }



}
