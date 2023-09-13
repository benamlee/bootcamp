import java.util.Arrays;
import java.util.Random;

public class Demo {

  int age;

  public static void main(String[] args) {
    int[] nums = new int[3];
    // int[] nums; -> declaration
    // new int[3]; -> initialization
    nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // re-assignment

    int[][] matrix = new int[3][4];
    // 1, 2, 3, 10
    // 4, 5, 6, 7
    // 2, 3, 4, 1
    // 3 rows x 4 columns
    System.out.println(matrix.length); // 3 rows
    System.out.println(matrix[0].length); // 4 (column length of row[0])
    // matrix[0] return row:0 int[] array
    // matrix[0][2] return idx 2 from the array of row 0

    // random a number and assign to an 2D array (0-12)
    for (int i = 0; i < matrix.length; i++) { // 3 rows
      for (int j = 0; j < matrix[0].length; j++) { // 4 columns
        matrix[i][j] = new Random().nextInt(13);
      }
    }

    System.out.println(Arrays.deepToString(matrix));

    int[] arr = new int[matrix.length * matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        arr[i * (matrix[0].length) + j] = matrix[i][j]; // combine two actions
      }
    }
    System.out.println(Arrays.toString(arr));

    // Convert 2D array to a String
    String str = "";
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        str += matrix[i][j]; // combine two actions
      }
    }
    System.out.println(str);

    // 3D array
    int[][][] arr3d = new int[3][4][5];
    int[][][][] arr4d = new int[1][2][3][4];
    System.out.println(Arrays.deepToString(arr3d));

    Demo[][] demo = new Demo[2][2];
    demo[0][0] = new Demo();
    demo[0][1] = new Demo();
    demo[1][0] = new Demo();
    demo[1][1] = new Demo();

    for (int i = 0; i < demo.length; i++) {
      for (int j = 0; j < demo[0].length; j++) {
        System.out.println(demo[i][j].age);
      }
    }

    String[][] strings = new String[][] {{"abc", "def"}, {"xyz", "ijk"}};
    for (int i = 0; i < strings.length; i++) {
      for (int j = 0; j < strings[0].length; j++) {
        System.out.println(strings[i][j]);
      }
    }


  }

}
