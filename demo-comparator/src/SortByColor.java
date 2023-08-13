import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortByColor implements Comparator<Ball> {


  @Override
  public int compare(Ball b1, Ball b2) {
    // 1 -> means put b2 to left
    // -1 -> means put b1 to left
    // return b2.color.id < b1.color.id ? 1 : -1; // 冇this，interface迫人finish但當static method用
    if (b2.color == Color.YELLOW && b1.color == Color.YELLOW)
      return b2.id < b1.id ? 1 : -1;
    if (b2.color == Color.YELLOW)
      return 1;
    if (b1.color == Color.YELLOW)
      return -1;
    return b2.id > b1.id ? 1 : -1;

  }

  public static void main(String[] args) {
    ArrayList<Ball> balls = new ArrayList<>();
    balls.add(new Ball(4, Color.YELLOW));
    balls.add(new Ball(1, Color.BLUE));
    balls.add(new Ball(5, Color.YELLOW));
    balls.add(new Ball(100, Color.RED));
    Collections.sort(balls, new SortByColor()); // call compare, static method, 要自己implements Override
    System.out.println(balls);

  }

}
