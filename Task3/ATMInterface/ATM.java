import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processOption(int option) {
        Scanner scanner = new Scanner(System.in);

        switch (option) {
            case 1:
                System.out.println("Balance: " + userAccount.getBalance());
                break;
            case 2:
                System.out.println("Enter deposit amount:");
                try {
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(depositAmount);
                    System.out.println("Deposit successful. New balance: " + userAccount.getBalance());
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
                break;
            case 3:
                System.out.println("Enter withdrawal amount:");
                try {
                    double withdrawalAmount = scanner.nextDouble();
                    if (userAccount.getBalance() >= withdrawalAmount) {
                        userAccount.withdraw(withdrawalAmount);
                        System.out.println("Withdrawal successful. New balance: " + userAccount.getBalance());
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }

        scanner.close();
    }
}
