package zoo;
public class Zoo<T> {

  T animal;

  private Zoo() {}

  private Zoo(T animal) {
    this.animal = animal;
  }

  // Zoo<T> -> return type
  // T -> inout paramemter
  // <T extends Animal> -> the range of T, control this method T, not the whole class
  public static <T extends Animal> Zoo<T> of(T animal) { // 前面<T>是用來描述 T 的範圍
    return new Zoo<>(animal); // static method 要獨自寫範圍
  }

  public T getAnimal() {
    return this.animal;
  }

  public void setAnimal(T animal) {
    this.animal = animal;
  }



}
