import java.util.Objects;

public class Department {
  String name;
  // can have list of staff

  public Department(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Dept[name=" + this.name + "]";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (!(o instanceof Department))
      return false;
    Department department = (Department) o;
    // return Objects.equals(this.name, department.name);
    return this.name==department.name;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.name);
  }
}
