public class TestStringBuilder {
    public static void main(String[] args) throws InterruptedException{
        StringBuilder sbuilder = new StringBuilder("");
        // multi-thread 不能用 StringBuilder , 要用StringBuffer
        // StringBuilder 用char Array，load唔到時會改唔切length , add唔到char cos index out of bound

        Runnable appendS = () -> {
            for (int i = 0; i < 100; i++) {
                sbuilder.append("s"); // concat()-> non-atomic operation
            }
        };

        Thread thread1 = new Thread(appendS);
        Thread thread2 = new Thread(appendS);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(sbuilder.length());
    }

}
