import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Company2 {
    private Staff[] staffs;

    public Company2() {
        staffs = new Staff[0];
    }

    public Company2(Staff[] staffs) {
        this.staffs = staffs;
    }

    public Staff[] getStaffs() {
        return this.staffs;
    }

    public void add(Staff staff) {
        Staff[] original = this.staffs; // 抄地址，但短array obj仍存在，比original裝住
        this.staffs = new Staff[this.staffs.length + 1]; // 新obj
        for (int i = 0; i < original.length; i++) {
            this.staffs[i] = original[i];
        }
        this.staffs[this.staffs.length - 1] = staff;
    }

    public void remove(Staff staff) {
        int idx = -1;
        for (int i = 0; i < this.staffs.length; i++) {
            if (this.staffs[i].equals(staff))
                idx = i;
        }
        if (idx == -1)
            return;
        Staff[] original = this.staffs;
        this.staffs = new Staff[this.staffs.length - 1];
        int j = 0;
        for (int i = 0; i < original.length; i++) {
            if (j == idx) {
                j++;
                continue;
            }
            this.staffs[i] = original[j++];
        }
    }

    public static void main(String[] args) {
        Company2 company = new Company2();
        company.add(new Staff(1, 5000, "John"));
        System.out.println(company.staffs.length); // 1
        company.add(new Staff(2, 10000, "Mary"));
        System.out.println(company.staffs.length); // 2

        List<Person8> persons = Arrays.stream(company.getStaffs()) //
                .filter(e -> e.getSalary() > 20000) //
                .map(e -> new Person8(e.getName())) //
                .collect(Collectors.toList());
        System.out.println(persons);

        Integer a=127;
        Integer a2=new Integer(127);
        System.out.println(a2==a);

    }
}
