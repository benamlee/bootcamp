public class InterviewQuestion {
    public static void main(String[] args) {
        printMersennePrimes();
        // for (int i = 0; i <= 100; i++) {
        //     if (isPrime(i))
        //         System.out.println(i);
        // }
        System.out.println((int)Math.pow(2, -4));
    }

    public static void printMersennePrimes() {
        for (int i = 2; Math.pow(2, i) <= 10000; i++) { // prime number start from 2
            if (isPrime(i) && isPrime((int) Math.pow(2, i) - 1)) {
                System.out.println((int) Math.pow(2, i) - 1);
            }
        }
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
