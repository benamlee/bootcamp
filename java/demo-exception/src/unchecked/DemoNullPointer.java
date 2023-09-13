package unchecked;
public class DemoNullPointer {
  public static void main(String[] args) {
    String[] strings = new String[4];
    try{
      for(String string:strings){
        if(string.charAt(0)=='a'){
          System.out.println("first character is a");
        }
      }
    }
    catch (NullPointerException e){
      System.out.println("Null pointer exception");
    }
  }
}
