import java.util.ArrayList;
import java.util.List;

public class Revision<T extends Number> {
    ArrayList<T> datas;

    public boolean add(T data) {
        return datas.add(data);
    }

    public static <T> T add(T data) { // static the T is not related to instance
        return data;
    }

    public static <T extends Number> void add2(T data) { // static the T is not related to instance
        // <T> write restriction
    }

    public static void add3(List<? super Integer> data) { // static the T is not related to instance
        // <T> write restriction
    }
}
