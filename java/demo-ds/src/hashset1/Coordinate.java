package hashset1;

import java.util.Objects;

public class Coordinate {
  int x;
  int y;

  public Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Coordinate))
      return false;
    Coordinate coordinate = (Coordinate) o;
    return this.x == coordinate.x && this.y == coordinate.y;
  }

  @Override
  public int hashCode() { // align with equals, check id & color
    return Objects.hash(this.x, this.y);
  }



}
