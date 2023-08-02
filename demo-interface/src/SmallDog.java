public class SmallDog extends Dog {


  @Override
  public void jump() { // this is contract from Class Dog
    super.addScore(5);
  }

  public static void main(String[] args) {
    SmallDog smallDog = new SmallDog();
    smallDog.jump(); // +5
    System.out.println(smallDog.getScore()); // 5
    smallDog.up(); // +2
    System.out.println(smallDog.getScore()); // 7



  }

}
