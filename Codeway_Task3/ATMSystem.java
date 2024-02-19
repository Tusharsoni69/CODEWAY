import java.util.Scanner;

// Represents an Automated Teller Machine
class ATM {
    private BankAccount userAccount;

    // Constructor
    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    // Display the main menu
    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    // Handles withdrawal operation
    public void withdraw(double amount) {
        try {
            userAccount.withdraw(amount);
            System.out.println("Withdrawal successful. Current balance: " + userAccount.getBalance());
        } catch (InsufficientFundsException e) {
            System.out.println("Insufficient funds. Please try again.");
        }
    }

    // Handles deposit operation
    public void deposit(double amount) {
        userAccount.deposit(amount);
        System.out.println("Deposit successful. Current balance: " + userAccount.getBalance());
    }

    // Displays current account balance
    public void checkBalance() {
        System.out.println("Current balance: " + userAccount.getBalance());
    }
}

// Represents a user's bank account
class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Gets current balance
    public double getBalance() {
        return balance;
    }

    // Withdraws specified amount from the account
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException();
        }
        balance -= amount;
    }

    // Deposits specified amount into the account
    public void deposit(double amount) {
        balance += amount;
    }
}

// Represents an exception for insufficient funds during withdrawal
class InsufficientFundsException extends Exception {
    // Constructor
    public InsufficientFundsException() {
        super("Insufficient funds");
    }
}

// Main class to run the ATM Interface program
public class ATMSystem {
    // Main method
    public static void main(String[] args)  {
        BankAccount account = new BankAccount(1000);
        ATM atm = new ATM(account);
        Scanner scanner = new Scanner(System.in);

        // Main program loop
        while (true) {
            try {
                atm.displayMenu();
                System.out.print("Enter option: ");
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 3:
                        atm.checkBalance();
                        break;
                    case 4:
                        System.out.println("Exiting ATM. Thank you!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next();
            }
        }
    }
}
