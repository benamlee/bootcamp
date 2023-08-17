package tryabstractinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EE {
  AA a;
  BB b;

  public static void main(String[] args) {
    EE e = new EE();
    // e.a=new AA(100);
    // System.out.println(e.a.a);; // e.a not yet define is null and its all method attributes cannot use
    e.b = new AA(100); // here e.b can declare AA || BB class
    System.out.println(e.b.b);

 
  }
}
