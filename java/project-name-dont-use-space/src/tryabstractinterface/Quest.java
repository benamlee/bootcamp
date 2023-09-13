package tryabstractinterface;

import java.util.ArrayList;
import java.util.List;

public class Quest {
  // static byte counter =5;
  // int a=2;
  // static int hc=0;
  // static Map<Integer, An> hashmap = new HashMap<>();

  // static class An{
  // String name;

  // An(String name){
  // this.name=name;
  // hc++;
  // }
  // String getName(){
  // return this.name;
  // }
  // }

  // public static void addAn(An an){
  // hashmap.put(hc, an);
  // }

  // int s = 100;
  // static Quest c = new Quest();

  // private Quest() {}

  // public static Quest getC() {
  //   return c;
  // }

  // public void setS(int s) {
  //   this.s = s;
  // }

    static final List<Character> characters;
    private static final char[] chars={'a','r','s','h','u'};
    int a=0;

    static{characters=new ArrayList<>();}

    {characters.add('b');}

  public static void main(String[] args) {
    // Quest q=new Quest();
    // for(Integer i =0;i<2;i++){
    // counter=(byte)(i+q.a);

    // }
    // System.out.println(counter);

    // LinkedList<String> strings = new LinkedList<>();
    // for (int i = 0; i < 4; i++) {
    // if (i % 2 > 0) {
    // strings.addLast("N");
    // } else {
    // strings.addLast("C");
    // }
    // }
    // strings.addFirst("V");
    // strings.add("T");
    // strings.add(4,"E");
    // strings.set(2, "I");
    // System.out.println(strings);


    // addAn(new An("Yes")); // 先 create 再put, so hc=1,2,3,4
    // addAn(new An("NO"));
    // addAn(new An("Yes"));
    // addAn(new An("Nope"));

    // hashmap.remove(3);
    // System.out.println(hashmap);
    // // System.out.println(hashmap.get(3).getName());


    // Deque<Quest> dq = new LinkedList<>();
    // Quest te = Quest.getC();
    // Quest to = Quest.getC();

    // te.setS(80);
    // dq.add(te);
    // dq.push(to);
    // System.out.println(dq.getLast().s + " " + dq.getFirst().s);

    for(char c:chars){
      characters.add(c);
    }
    System.out.println(characters);
    System.out.println(characters.size());
  }

}

