abstract class Account {
    protected String accountNumber;
    protected double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract void calculateInterest();

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends Account {
    private double interestRate = 0.04; 

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void calculateInterest() {
        double interest = balance * interestRate;
        System.out.println("Savings Account Interest: " + interest);
    }
}


class CurrentAccount extends Account {
    private double overdraftLimit = 5000;

    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void calculateInterest() {
        System.out.println("Current accounts do not earn interest.");
    }

    public void checkOverdraft() {
        System.out.println("Overdraft limit: " + overdraftLimit);
    }
}

public class Lab4 {
    public static void main(String[] args) {
        Account acc1 = new SavingsAccount("SA123", 10000);
        Account acc2 = new CurrentAccount("CA456", 20000);

        acc1.displayDetails();
        acc1.calculateInterest();

        System.out.println("---------------------------");

        acc2.displayDetails();
        acc2.calculateInterest();
    }
}
