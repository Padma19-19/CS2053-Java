class LowBalanceException extends Exception {
    public LowBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void withdraw(double amount) throws LowBalanceException {
        System.out.println("Attempting to withdraw " + amount);

        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        } else if (amount > balance) {
            throw new LowBalanceException("Insufficient balance! Current balance: " + balance);
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful! Remaining balance: " + balance);
        }
    }

    public void displayBalance() {
        System.out.println("Account: " + accountNumber + " | Balance: " + balance);
    }
}


public class Lab6 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("ACC1001", 5000);

        account.displayBalance();

        try {
            account.withdraw(2000);  
            account.withdraw(4000);  
        } 
        catch (LowBalanceException e) {
            System.out.println("Custom Exception Caught: " + e.getMessage());
        } 
        catch (IllegalArgumentException e) {
            System.out.println("Built-in Exception Caught: " + e.getMessage());
        } 
        finally {
            System.out.println("Transaction complete. Thank you for banking with us!");
        }
    }
}
