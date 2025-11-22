import java.util.Scanner;

class ATM {
    private double balance;
    private int pin = 1234;

    public boolean verifyPin(int enteredPin) {
        return enteredPin == pin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATM atm = new ATM();

        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();

        if (!atm.verifyPin(enteredPin)) {
            System.out.println("Incorrect PIN. Exiting...");
            return;
        }

        while (true) {
            System.out.println("\n----- ATM MENU -----");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current balance: ₹" + atm.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    atm.deposit(sc.nextDouble());
                    System.out.println("Deposit successful.");
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    if (atm.withdraw(sc.nextDouble())) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}