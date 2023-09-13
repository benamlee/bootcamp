public class Student<T extends Number, U> {
    T data;

    public static void main(String[] args) {
        Student<Integer, String> student = new Student<>();
        System.out.println(Student.getThing(2).getClass()); // Integer

    }

    public T getData(){
        return this.data;
    }

    public static <S> S getThing(S data){
        return data;
    }
}
