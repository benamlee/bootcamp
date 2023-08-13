public class LeetCode {
    public static void main(String[] args) {

        
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int sec = 0;
        while (tickets[k] != 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] != 0) {
                    sec++;
                    tickets[i]--;
                }
                if (tickets[k]==0)
                break;
            }
        }
        return sec;
    }
}
