# Task 3: ATM Interface

## Description
This task involves creating an ATM interface with the following functionalities:
1. Display balance
2. Deposit money
3. Withdraw money
4. Exit

## Implementation
- `ATM.java`: Represents the ATM interface with methods to display the menu and process user options.
- `BankAccount.java`: Represents the user's bank account with methods to get balance, deposit, and withdraw money. Includes exception handling for invalid inputs and insufficient balance.

## How to Use
1. Create a `BankAccount` object with the initial balance.
2. Create an `ATM` object passing the `BankAccount` object.
3. Call `displayMenu()` to show the ATM menu.
4. Enter the option number to perform the desired action.

## Example Usage
```java
public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initial balance
        ATM atm = new ATM(userAccount);
        atm.displayMenu();
        // Call atm.processOption(option) based on user input
    }
}
