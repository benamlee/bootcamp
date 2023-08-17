package comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Card extends Paper {
  int number;

  public Card(int number, int size) {
    super(size);
    this.number = number;
  }

  @Override // Compiler
  public String toString() {
    return "[number=" + this.number + ", size=" + super.size + "]";
  }

  public static void main(String[] args) { // 想有次序就會用List
    List<Card> cards = Arrays.asList(new Card(1, 2), new Card(4, 3));
    System.out.println(cards.getClass().getName());
    Collections.sort(cards, new SortBySize());
    System.out.println(cards);

    List<? extends Number> numbers = new ArrayList<Byte>(); // 平時右邊<>冇寫=默認同左邊一樣
    numbers = new ArrayList<Integer>();
    numbers = new ArrayList<Double>(); // 因為夠寬闊 所以裝到

    // List<T extends Number> numbers = new ArrayList<>(); // T從來在run-time不能使用

    Number number = new Integer(100);
    number = new Double(20000); // Polymorphism
    number = Integer.valueOf(50);
    number = Double.valueOf(40);



  }
}
