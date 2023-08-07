package arraylist1;
import java.util.Objects;
import java.util.Random;

public class Ball {
  private int id;
  private Color1 color;
  
  private static int idCounter = 0;

  public Ball(Color1 color) {
    this.id = idCounter++;
    this.color = color;
  }

  public int getScore() {
    return this.color.getScore();
  }

  public int getId() {
    return this.id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Ball))
      return false;
    Ball b = (Ball) o;
    return this.id == b.id && this.color == b.color;
  }

  @Override
  public int hashCode() { // align with equals, check id & color
    return Objects.hash(this.id, this.color);
  }

  @Override
  public String toString() {
    return "[" + "id=" + this.id + ", color1=" + this.color.name() + "]";
  }

  public static Ball random() {
    // Get Random Color
    int a = new Random().nextInt(3);
    Color1 color = Color1.getColor1(a);
    return new Ball(color);
  }

}


