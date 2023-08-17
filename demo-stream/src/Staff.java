import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Staff {
  String name;
  Department department; // 形容個人係邊個department
  int performance;

  public Staff(String name, Department department, int performance) {
    this.name = name;
    this.department = department;
    this.performance = performance;
  }

  @Override
  public String toString() {
    return "Staff[name=" + this.name + " " + this.department + "]";
  }

  public static void main(String[] args) {
    List<Staff> staffs =
        Arrays.asList(new Staff("Mary", new Department("HR"), 50),
            new Staff("Peter", new Department("IT"), 60),
            new Staff("Eric", new Department("IT"), 70));
    // Map<Department, List<Staff>>
    // example 1
    staffs.stream().collect(Collectors.groupingBy(staff -> staff.department)) //
        .forEach(
            (dept, staffList) -> System.out.println(dept + " " + staffList));

    System.out.println();
    // example 2
    Map<Department, List<Staff>> depts = staffs.stream()
        .collect(Collectors.groupingBy(staff -> staff.department));

    depts.forEach(
        (dept, staffList) -> System.out.println(dept + " " + staffList));

    for (Staff staff : depts.get(new Department("IT"))) {
      System.out.println(staff.name);
    }

    //
    Map<Boolean, List<Staff>> gradeMap = staffs.stream()
        .collect(Collectors.partitioningBy(staff -> staff.performance >= 60));
    // System.out.println(gradeMap); // {false=[Staff[name=Mary Dept[name=HR]]], true=[Staff[name=Peter Dept[name=IT]], Staff[name=Eric Dept[name=IT]]]}
    gradeMap.entrySet().stream() // list, set -> stream()
        .forEach(e -> System.out.println(e));
    // false=[Staff[name=Mary Dept[name=HR]]]
    // true=[Staff[name=Peter Dept[name=IT]], Staff[name=Eric Dept[name=IT]]]
  }


}
