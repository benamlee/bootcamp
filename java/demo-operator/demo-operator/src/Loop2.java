public class Loop2 {
  public static void main(String[] args) {
    // break
    for (int i = 0; i < 6; ++i) {
      for (int j = 0; j < 3; ++j) {
        System.out.println("i=" + i + ", j=" + j);
        if (i == j) {
          break; // this break statement just break the inner loop
        }

      }

    }
    // i=0, j=0, print, check, break j loop, go to i=1
    // i=1, j=0, print
    // i=1, j=1, print, check, break j loop, go to i=2
    // i=2, j=0, print
    // i=2, j=1, print
    // i=2, j=2, print, check, break j loop, go to i=3
    // i=3, j=0, print
    // i=3, j=1, print
    // i=3, j=2, print
    // ...
    // i=5, j=2, print

    // continue
    System.out.println("Example of Continue:");
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 3; j++) {
        if (i == j) {
          // below continue should have coding to be skipped, otherwise it is useless
          continue; // skip the rest in inner loop, go to next iteration
        }
        System.out.println("i=" + i + ", j=" + j);
        // if (i != j) {
        // System.out.println("i=" + i + ", j=" + j);
        // } // it is the same meaning, different way
      }
    }

    // i=0, j=0, skip print, go to j=1
    // i=0, j=1, print
    // i=0, j=2, print
    // i=1, j=0, print
    // i=1, j=1, skip print, go to j=2
    // i=1, j=2, print
    // i=2, j=0, print
    // i=2, j=1, print
    // i=2, j=2, skip print, and j is end, go to i=3
    // i=3, j=0, print, ...
    // i=5, j=2, print

    // "break" the loop will not run the further i, "continue" just skip action in the middle and run i to the end

    String str = "I love programming. I love Java.";
    System.out.println("str lenght=" + str.length());
    // for loop 是為了操作數據
    // for loop iteration times, based on the length of the String
    for (int i = 0; i < str.length() - 30; i++) { // i < 32 (0 - 31)
      System.out.println("Hello");
    }

    // Print the index of the first occurrence of the character 'e'
    // str.charAt(int index)
    System.out.println("print the first index of e");
    for (int i = 0; i < str.length(); ++i) {
      if (str.charAt(i) == 'e') {
        System.out.println("1st index=" + i);
        break;
      }
    }

    System.out.println("print the second index of e");
    for (int i = 0; i < str.length(); ++i) {
      if (str.charAt(i) == 'e') {
        for (int j = i + 1; j < str.length(); ++j) {
          if (str.charAt(j) == 'e') {
            System.out.println("2nd index=" + j);
            break;
          }
        }
        break;
      }
    } // 咁寫只可以skip一次，搵第2個index

    // str = "hohgiugenkgygheobiugieohyugfffe";
    int n = 3;
    System.out.println("print the " + n + " th index of e");

    for (int i = 0; i < str.length(); ++i) {
      if (str.charAt(i) == 'e') {
        n--;
        if (n == 0) {
          System.out.println(i);
          break;
        }
      }
    }

    // check if 'y' exists in the string
    // Found or Not Found
    System.out.println(str);
    char try10 = 'i';
    System.out.println(try10);
    for (int i = 0; i < str.length(); ++i) {
      if (str.charAt(i) == try10) {
        System.out.println("try use continue Found");
        break;
      } else if (i < str.length() - 1) {
        continue;
      }
      // if (i == str.length() - 1 && str.charAt(i) != try10) {
      System.out.println("try use continue Not Found");
      // }
    }


    boolean found = false;
    for (int i = 0; i < str.length(); ++i) {
      if (str.charAt(i) == 'y') {
        found = true;
        break;
      }
    } // 重要!!! 可以數完哂for loop做完野，之後出面先做print
    if (found == true) {
      System.out.println("Found");
    } else {
      System.out.println("Not Found");
    }
    // if the number of occurrence of target >= 3, print Yes
    // otherwise, print No
    int count = 0;
    char target = 'I';
    boolean found2 = false;
    for (int i = 0; i < str.length(); ++i) {
      if (str.charAt(i) == target) {
        count++;
      }
      if (count >= 3) { // nice to have
        found2 = true;
        break; // 提早完loop，優化coding，load快d
      }
    }
    if (found2) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }


  }
}
