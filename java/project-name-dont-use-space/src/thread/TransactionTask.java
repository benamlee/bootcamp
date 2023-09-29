package thread;

class TransactionTask implements Runnable {
    private BankAccount sourceAccount;
    private BankAccount targetAccount;
    private double amount;

    public TransactionTask(BankAccount sourceAccount, BankAccount targetAccount,
            double amount) {
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        // if (sourceAccount.withdraw(amount))
        //     targetAccount.deposit(amount);
        sourceAccount.transaction(targetAccount, amount);
    }
}
