public class Ball implements Comparable<Ball> {
  int id;
  Color color;

  public Ball(int id, Color color) {
    this.id = id;
    this.color = color;
  }

  // Yellow come first, if color same, id ascending order
  // if not Yellow, id descending order
  @Override
  public int compareTo(Ball ball) {
    // return ball.id > this.id ? 1 : -1; // 調轉 sorting
    if (this.color == Color.YELLOW && ball.color == Color.YELLOW)
      return ball.id < this.id ? 1 : -1;
    if (this.color == Color.YELLOW)
      return -1;
    if (ball.color == Color.YELLOW)
      return 1;
    return ball.id > this.id ? 1 : -1;
  }

  @Override
  public String toString() {
    return "[id=" + this.id + " , color=" + this.color + "]";
  }
}
