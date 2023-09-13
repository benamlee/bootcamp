package arraylist1;
public class Person implements Player {

  // Pocket leftPocket;
  // Pocket rightPocket; 固定得左右褲袋
  Pocket[] pockets;

  public Person() { // control Person
    this.pockets = new Pocket[] {new Pocket(), new Pocket()}; // 呢堆class唔係extends，所以用到其他class 做 attribute 就要 new，否則得個蓋會null哂

  }

  @Override
  public int totalScore() {
    return this.getLeftPocket().totalScore()
        + this.getRightPocket().totalScore();
  }

  public Pocket getLeftPocket() {
    return this.pockets[0];
  }

  public Pocket getRightPocket() {
    return this.pockets[1];
  }



  public static void main(String[] args) {
    Person p1 = new Person();
    Player.fillThePocket(p1.getLeftPocket());
    Player.fillThePocket(p1.getRightPocket());
    System.out.println(p1.getLeftPocket().getSize()); // 5
    System.out.println(p1.getRightPocket().getSize()); // 5

    System.out.println("p1 Total Score:" + p1.totalScore());
    System.out.println(
        "p1 Left Pocket Ball Details:" + p1.getLeftPocket().toString());
    System.out.println(
        "p1 Right Pocket Ball Details:" + p1.getRightPocket().toString());

    Person p2 = new Person();
    Player.fillThePocket(p2.getLeftPocket());
    Player.fillThePocket(p2.getRightPocket());



  }

  // public static int compare(Person a, Person b){

  // }

}
