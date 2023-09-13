package queue1;

public class Staff implements Walkable{

  public void walk(){
    System.out.println("Staff walk");
  }

  public static void main(String[] args) {
    Walkable person = new Student(); // 只要轉 new 既野 (Student() / Staff()) , method 就會唔同
    int a =100;
    if (a>10){
      person.walk();
    }
  }
  
}
