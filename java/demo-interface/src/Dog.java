public class Dog extends GameMember implements Move {

  String name;

  @Override
  public void up() {
    System.out.println("Moving up");
    super.addScore(2);
    // GameMember.up(this);
  }

  @Override
  public void jump() {
    super.addScore(3);
  }

  public void bigJump() {}

  @Override
  public void down() {}

  @Override
  public void left() {}

  @Override
  public void right() {}

  public static void main(String[] args) {
    Dog dog = new Dog();
    dog.print(); // Duplicate methods named print -> all superclass first
  }

}
