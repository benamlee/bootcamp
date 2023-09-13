package trybrenda;

import java.util.ArrayList;
import java.util.List;

public abstract class Participant<T> {
  int pId;
  private static int count = 10000;

  public Participant() {
    this.pId = count++;
  }

  // public Participant(List<T> available) {
  //   this.available = available;
  // }

  // public void add(T available) {
  //   this.available.add(available);
  // }
}