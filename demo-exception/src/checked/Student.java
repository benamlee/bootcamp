package checked;

public class Student {
  String name;
  long pocketMoney;

  public Student(String name) {
    this.name = name;
  }

  public Student() {

  }

  public void setName(String name) throws NameTooLongException {
    if (name.length() > 10)
      throw new NameTooLongException("Name is too long (> 10)"); // constructor
    this.name = name;
  }

  public void setPocketMoney(long pocketMoney) throws AmountZeroException {
    if (pocketMoney <= 0)
      throw new AmountZeroException("Amount <= 0");
    this.pocketMoney = pocketMoney;
  }

  public static void main(String[] args) { // if exception, throw it to the caller
    Student student = new Student("John");
    try {
      int i = 10 / 0;
      student.setPocketMoney(-3);
      student.setName("Peter abasdasddf");
    } catch (NameTooLongException | AmountZeroException e) { // if exception, handle
      System.out.println(e.getMessage());
      System.out.println("Student Setter Issue, message: " + e.getMessage());
    } catch (Exception e) { // null pointer , /0 , all exception
      System.out.println(e.getMessage()); // Exception e 係差寫法，所有錯都係呢度接住
      System.out.println("Hok gun");
    } finally { // 通常同 return
      System.out.println("finally");
    }

    System.out.println("can it be here? yes");

    String a = null;
    System.out.println("as".equals(a)); // false
    System.out.println(a.equals("as"));

    // Student student2 = new Student();
    // student2.name.length(); // student2.name is null pointer, uncheck exception


  }
}
