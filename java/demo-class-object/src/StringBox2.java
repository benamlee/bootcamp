import java.util.Arrays;

public class StringBox2 {
  char[] string;

  public StringBox2() {}

  public StringBox2(char[] s) {
    // this.string = new char[s.length];
    // for (int i = 0; i < s.length; i++) {
    //   this.string[i] = s[i];
    // } // 方法1
    this.string = Arrays.copyOf(s, s.length); // 方法2
    // copyOf() -> new array object, with the copy values of the original array
  }

  public StringBox2 append(String s){
    char[] res=new char[this.string.length+s.length()];
    // for(int i=0;i<res.length;i++){
    //   if(i<this.string.length){
    //     res[i]=this.string[i];
    //   }else{
    //     res[i]=s.charAt(i-this.string.length);
    //   }
    // } // my for loop
      int idx=0;
      int j=0;
      while(j<this.string.length){
        res[idx]=this.string[j];
        idx++;
        j++;
      }
      j=0;
      while(j<s.length()){
        res[idx]=s.charAt(j);
        idx++;
        j++;
      } // vincent while loop
    this.string=res;
    return this;
  }

  public String toString() {
    return Arrays.toString(this.string);
  }

  public static void main(String[] args) {
    char[] chars = new char[] {'a', 'c', 'b'};
    StringBox2 box = new StringBox2(chars);
    System.out.println(box.toString());

    chars[1] = 'x';
    System.out.println(box.toString());
    System.out.println(Arrays.toString(chars));

    System.out.println(box.append("aaa").toString());

  }
}
