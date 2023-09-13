package revision;

public class TestException {

    public static int method(int amount) throws BusinessException {
        if (amount >= 0)
            return amount * 100;
        throw new BusinessException("amount < 0");
    }

    public static int method2(int amount) throws AbcException {
        if (amount >= 0)
            return amount * 100;
        throw new AbcException();
    }

    // Approach 2: throws the BusinessException in method signature
    public static void main(String[] args) throws BusinessException {
        // Exception // checked exception
        // Approach 1: handled by try & catch
        try {
            int result = method(2); // once hit error, cannot proceed
            // skip the rest of the codes ...
        } catch (BusinessException e) {
            System.out.println(e.getMessage()); // amount < 0
        } finally {
            System.out.println("final code block");
        }

        // RuntimeException // unchecked exception
        int a = -5;
        int result2;
        if (a >= -100)
            result2 = method2(a); // Don't need to handle Runtime exception

    }
}
