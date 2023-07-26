public class Stringabcdcba {
  public static void main(String[] args) {
    String s="babeeebab";
    System.out.println(isPalindrome(s));
    System.out.println(longestPalindrome(s));
  }
      public static String longestPalindrome(String s) {
        //   int start=0;
        //   int end=0;
        //   int length=0;
        //   int m,n;
        //   for(int i=0;i<s.length();i++){
        //       for(int j=i+1;j<s.length();j++){
        //           m=i;
        //           n=j;
        //           while(n>m&&s.charAt(m)==s.charAt(n)){
        //               m++;
        //               n--;
        //               // System.out.println("m"+m+"n"+n);
        //           }
        //           if((n==m||n==m-1)&&j-i>=length){
        //               length=j-i;
        //               start=i;
        //               end=j;
        //               // System.out.println("s"+start+"e"+end);
        //           }
        //       }
        //   }
        //   return s.substring(start, end+1);


        int st=0;
        int e=0;
        int length=0;
        for(int i=0;i<s.length();i++){
            for(int j=s.length();j>i;j--){
                System.out.println("i"+i+"j"+j);
                if(isPalindrome(s.substring(i,j))&&j-i>length){
                    length=j-i;
                    st=i;
                    e=j;
                }
            }
        }
        System.out.println("st"+st+"e"+e);
        return s.substring(st,e);
      }

      public static boolean isPalindrome(String s) {
        for(int i = 0; i < s.length() / 2; i++){
          if(s.charAt(i) != s.charAt(s.length()-i-1)){
            return false;
          }
        }
        return true;
      }
  }
