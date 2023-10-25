import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.HashSet;
import java.util.Locale;

public class TestingCode {


    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDateTime);

        int weekNumber = localDateTime
                .get(WeekFields.of(Locale.US).weekOfWeekBasedYear());
        // int weekNumber2 = LocalDateTimes.weekOfWeekYear().get(localDateTime);
        System.out.println(weekNumber);

        HashSet<Integer> set = new HashSet<>();
        set.contains(1);

    }
}
