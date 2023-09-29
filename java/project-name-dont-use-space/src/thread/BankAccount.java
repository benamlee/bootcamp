package thread;

class BankAccount {
    private String accountName;
    private double balance;

    public BankAccount(String accountName, double balance) {
        this.accountName = accountName;
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited $"
                + amount + " into " + accountName + ". New balance: $"
                + balance);
    }

    public synchronized boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew $"
                    + amount + " from " + accountName + ". New balance: $"
                    + balance);
            return true;
        } else {
            System.out.println(Thread.currentThread().getName()
                    + " attempted to withdraw $" + amount + " from "
                    + accountName + " but insufficient funds.");
            return false;
        }

    }

    public synchronized void transaction(BankAccount ac, double amount) { // combine withdraw and deposit
        for (int i = 0; i < 15000; i++) {
            if (this.balance >= amount) {
                this.balance -= amount;
                System.out.println(Thread.currentThread().getName()
                        + " withdrew $" + amount + " from " + this.accountName
                        + ". New balance: $" + this.balance);
                ac.balance += amount;
                System.out.println(Thread.currentThread().getName()
                        + " deposited $" + amount + " into " + ac.accountName
                        + ". New balance: $" + ac.balance);
            } else {
                System.out.println(Thread.currentThread().getName()
                        + " attempted to withdraw $" + amount + " from "
                        + this.accountName + " but insufficient funds.");
            }
        }
    }
}
