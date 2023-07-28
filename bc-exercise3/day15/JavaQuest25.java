/*
 * Question : Given a string s, return the number of segments in the string.

A segment is defined to be a contiguous sequence of non-space characters.

 * 
*/
public class JavaQuest25 {
  public static void main(String[] args) {
    System.out.println(countWords("       ")); // 0
    System.out.println(countWords("")); // 0
    System.out.println(countWords("Hello")); // 1
    System.out.println(countWords("Hello, my name is John."));// 5
    System.out.println(countWords(" . "));// 1
  }

  public static int countWords(String s) {
    // code here
    char[] arr=s.trim().toCharArray();
    int countSpace=0;
    for(int i=0;i<arr.length;i++){
      if(arr[i]==' ')
      countSpace++;
    }
    return arr.length==0?0:countSpace+1;
  }
}
