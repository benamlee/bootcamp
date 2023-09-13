public class DemoThread {
    public static void main(String[] args) {
        // Approach 1: Runnable (lanbda) to implement Thread
        // Task logic
        Runnable b = () -> {
            for (int i = 0; i < 100; i++)
                System.out.println("i=" + i);
        }; // step 4
           // Task
        Thread thread = new Thread(b); // Task Mangement

        System.out.println("start thread 1"); // step 1
        thread.start(); // step 2
        System.out.println("end thread 1"); // step 3

        // Approach 2: Create Printout Class implement Runnable
        Thread thread2 = new Thread(new PrintOut()); // Task Mangement
        System.out.println("start thread 2"); // step 1
        thread2.start(); // step 2
        System.out.println("end thread 2"); // step 3

        // Approach 3: Create PrintOut2 Class extends Thread
        PrintOut2 thread3 = new PrintOut2(); // Approach 3: extends Tread
        thread3.start();

        try {
            thread.join();
            thread2.join();
            thread3.join(); // 等哂所有做哂先繼續
        } catch (InterruptedException e) {

        }
        System.out.println("Main Thread Ends");


    }
}
