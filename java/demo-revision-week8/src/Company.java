import java.util.ArrayList;
import java.util.List;

public class Company {
    List<Staff> staffs;
    private static int counter;

    public Company() {
        staffs = new ArrayList<>();
    }

    public Company(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public void add(Staff staff) {
        this.staffs.add(staff);
        counter++;
    }

    public List<Staff> getStaffs() {
        return this.staffs;
    }

    /**
     * Get Staff nameb by staff id
     * 
     * @param staffId
     * @return
     */
    public String getStaffName(int staffId) {
        return this.staffs.stream() //
                .filter(e -> e.getID() == staffId) // List<Staff>
                .map(s -> s.getName()) // Convert List<Staff> to List<String>
                .findAny() // Optional<String>
                .orElse(null); // String
    }

    public static void main(String[] args) {
        Company company = new Company();
        company.getStaffs().add(new Staff(1, 20000, "John"));
        company.add(new Staff(2, 10000, "Peter"));

        System.out.println(company.getStaffName(1)); // John
    }

}
