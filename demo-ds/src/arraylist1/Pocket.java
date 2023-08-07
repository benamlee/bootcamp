package arraylist1;
import java.util.ArrayList;

public class Pocket {

  ArrayList<Ball> balls; // attribute

  public Pocket() {
    this.balls = new ArrayList<>(); // = new X() 係比緊一個「地址」，製造一支針 (null=冇針)
  }

  public boolean isFull() {
    return this.balls.size() >= 5;
  }

  public void removeFirstBall() {
    this.balls.remove(0);
  }

  public void add(Ball ball) {
    // if numbers of ball >= 5, remove the 1st (idx = 0), and add
    // if (this.balls.size() >= 5)
    // this.balls.remove(0);
    this.balls.add(ball); // run-time
  }

  public void remove(Ball ball) {
    this.balls.remove(ball); // first occurrence
  }

  public void remove(int ballId) { // Overloading
    for (Ball b : this.balls) {
      if (b.getId() == ballId) // primitives ==
        this.balls.remove(b);
      return; // remove the first one and return
    }
  }

  public int getSize() {
    return this.balls.size();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    for (Ball b : this.balls) {
      sb.append(b.toString());
      sb.append(",");
    }
    return sb.append("]").toString();
  }

  public int totalScore() {
    int total = 0;
    for (Ball b : this.balls) {
      total += b.getScore();
    }
    return total;
  }

}
