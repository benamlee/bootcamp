package trybrenda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tour{
  int id;
  private static int count = 0;
  List<Participant> participants;

  public Tour(int id, int available) {
    this.id = ++count;
    this.participants=new ArrayList<>();

  }

  // public Tour(int id, int available) {
  //   super(available);
  //   this.id = id;
  // }

  @Override
  public String toString() {
    return "Tour[number = " 
    + this.id + " ,available = " 
    
    + "]";
  }

  public static void main(String[] args) {
    List<Tour> tours = Arrays.asList(
      new Tour(100120, 10), 
      new Tour(214570, 13),
      new Tour(459987, 2),
      new Tour(257893, 5),
      new Tour(780092, 6)
    );
     Collections.sort(tours, new SortByAvailable());
    // Collections.sort(tours, new SortByAvailable());
    System.out.println(tours);
  }
}
