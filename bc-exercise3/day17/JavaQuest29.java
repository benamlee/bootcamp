/*Question : Given an integer n,
 add a dollar sign ("$") and a comma (",") as the thousands separator and return it in string format. */
/*Constraints:

0 <= n <= 231 - 1 */
public class JavaQuest29 {
  public static void main(String[] args) {
    System.out.println(separator(85));// $85
    System.out.println(separator(0));// $0
    System.out.println(separator(1000));// $1,000
    System.out.println(separator(123987405));// $123,987,405

  }

  public static String separator(int n) {
    // code here
    char[] arr = ("" + n).toCharArray();
    int a = arr.length;
    char[] arr2 = new char[ a + (a - 1) / 3];
    for (int i = arr2.length - 1; i >= 0; i--) {
      if ((arr2.length - i) % 4 == 0)
         arr2[i] = ',';
         else {
         arr2[i] = arr[a - 1];
         a--;
         }
    }
    return "$" + String.valueOf(arr2);
  }

}
