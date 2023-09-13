package arraylist1;
public interface Player {
  int totalScore();
  
  public static void fillThePocket(Pocket pocket) { // 諗每樣野係屬於邊個 // static method 要call就跟CLASS 名
    while (!pocket.isFull()) {
      // Random a ball with a random color
      pocket.add(Ball.random());
    }
  }
}
