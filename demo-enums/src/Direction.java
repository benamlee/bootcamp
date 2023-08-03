public enum Direction { // special keyword since Java 1.5
// 1. public class Direction extends Enum (Direction cannot extends anymore)
// 2. enum is final class

  // 全局唯一, 4 objects (EAST, SOUTH, WEST, NORTH)
  // new Direction("EAST")
  EAST('E', 90), //
  SOUTH('S', 180), //
  WEST('W', 270), //
  NORTH('N', 360), // 最後一個係 ","/";" 都得
  ;

  private char direction;
  private int degree;

  private Direction(char direction, int degree) {
    this.direction = direction;
    this.degree = degree;
  }

  public char getDirection() {
    return this.direction;
  }

  public int getDegree() {
    return this.degree;
  }

  // public void setDirection(char direction){
  // this.direction=direction;
  // } // 做到但唔應該改寫element，會整死成個用家

}
