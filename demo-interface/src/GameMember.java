public abstract class GameMember {

  int score;

  public int getScore() {
    return this.score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public void addScore(int score) {
    this.score += score;
  }

  public void print(){
    System.out.println("GameMember is jumping");
  }

  public abstract void left();

  public abstract void right();

  public abstract void up();

  public abstract void down();

  public static void upOnce(GameMember... members) { // multiple args
    for (GameMember member : members) {
      member.up(); // dog / cat objects
    }
  }

  public static void moveOnce(Move[] members) { // multiple args
    for (Move member : members) {
      member.jump(); // dog / cat objects
    }
  }

  public static void main(String[] args) {
    Dog dog = new Dog();
    Cat cat = new Cat();
    GameMember.upOnce(dog, cat); // ... 用 , , , 分隔
    System.out.println(dog.getScore()); // 2
    System.out.println(cat.getScore()); // 1

    GameMember.moveOnce(new Move[] {dog, cat});
    System.out.println(dog.getScore()); // 2+3=5
    System.out.println(cat.getScore()); // 1+4=5

    // Interface Move default instance method
    dog.print();
    cat.print();
    // static method
    System.out.println(Move.concat("ab", "cd"));

    Cow cow = new Cow();
    cow.print();


  }

}
