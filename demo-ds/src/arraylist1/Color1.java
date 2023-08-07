package arraylist1;

public enum Color1 {
  RED(100), //
  BLUE(200), //
  YELLOW(300), //
  ;

  private int score;


  private Color1(int score) {
    this.score = score;

  }

  public static Color1 getColor1(int id) {
    if (id < 0 || id > 2)
      return null;
    switch (id) {
      case 0:
        return Color1.RED;
      case 1:
        return Color1.BLUE;
      case 2:
        return Color1.YELLOW;
    }
    return null;
  }

  public int getScore() {
    return this.score;
  }

}
