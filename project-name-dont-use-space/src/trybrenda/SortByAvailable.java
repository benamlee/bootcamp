package trybrenda;

// import java.util.Comparator;

// public class SortByAvailable implements Comparable<Participant>{
//   int available;
//   private Object participant;

//   @Override
//   public int compareTo(Participant o) {
//     return this.available > participant.available ? -1 : 1;
//   }
// }

import java.util.Comparator;
public class SortByAvailable implements Comparator<Participant>{
  @Override
  public int compare(Participant o1, Participant o2) {
    return o2.available.size() > o1.available.size() ? -1 : 1;
  }
}
