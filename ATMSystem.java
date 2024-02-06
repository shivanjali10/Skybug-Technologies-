import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true; // Withdrawal successful
        } else {
            return false; // Insufficient funds or invalid amount
        }
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void performTransaction(int choice) {
        Scanner scanner = new Scanner(System.in);

        switch (choice) {
            case 1:
                System.out.print("Enter withdrawal amount: ");
                double withdrawalAmount = scanner.nextDouble();
                if (bankAccount.withdraw(withdrawalAmount)) {
                    System.out.println("Withdrawal successful. Remaining balance: $" + bankAccount.getBalance());
                } else {
                    System.out.println("Withdrawal failed. Insufficient funds or invalid amount.");
                }
                break;
            case 2:
                System.out.print("Enter deposit amount: ");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                System.out.println("Deposit successful. Updated balance: $" + bankAccount.getBalance());
                break;
            case 3:
                System.out.println("Current balance: $" + bankAccount.getBalance());
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        // Create a bank account with an initial balance of $1000
        BankAccount userAccount = new BankAccount(1000.0);
        // Create an ATM instance connected to the user's bank account
        ATM atm = new ATM(userAccount);

        while (true) {
            // Display the ATM menu
            atm.displayMenu();

            // Get user choice
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            // Perform the selected transaction
            atm.performTransaction(choice);
        }
    }
}
