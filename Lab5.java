interface Loan {
    void calculateEMI(double principal, int years);
}

class HomeLoan implements Loan {
    private double interestRate = 0.075; 

    @Override
    public void calculateEMI(double principal, int years) {
        double monthlyRate = interestRate / 12;
        int months = years * 12;
        double emi = (principal * monthlyRate * Math.pow(1 + monthlyRate, months)) /
                     (Math.pow(1 + monthlyRate, months) - 1);
        System.out.printf("Home Loan EMI: %.2f per month%n", emi);
    }
}

class CarLoan implements Loan {
    private double interestRate = 0.09; 

    @Override
    public void calculateEMI(double principal, int years) {
        double monthlyRate = interestRate / 12;
        int months = years * 12;
        double emi = (principal * monthlyRate * Math.pow(1 + monthlyRate, months)) /
                     (Math.pow(1 + monthlyRate, months) - 1);
        System.out.printf("Car Loan EMI: %.2f per month%n", emi);
    }
}


public class Lab5 {
    public static void main(String[] args) {
        Loan homeLoan = new HomeLoan();
        Loan carLoan = new CarLoan();

        System.out.println("Home Loan Calculation:");
        homeLoan.calculateEMI(500000, 10);

        System.out.println("\nCar Loan Calculation:");
        carLoan.calculateEMI(300000, 5);
    }
}
