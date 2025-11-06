import java.util.Scanner;

// Base class: Account
class Account {
    String customerName;
    int accountNumber;
    String accountType;
    double balance;

    Account(String name, int accNo, String accType, double bal) {
        customerName = name;
        accountNumber = accNo;
        accountType = accType;
        balance = bal;
    }

    // Accept deposit and update balance
    void deposit(double amount) {
        balance += amount;
        System.out.println("Amount deposited: " + amount);
        System.out.println("Updated Balance: " + balance);
    }

    // Display balance
    void displayBalance() {
        System.out.println("Account Holder: " + customerName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Current Balance: " + balance);
    }
}

// Derived class: Savings Account
class SavAcct extends Account {
    double interestRate = 5.0; // 5% annual compound interest

    SavAcct(String name, int accNo, double bal) {
        super(name, accNo, "Savings", bal);
    }

    // Compute and deposit compound interest
    void computeAndDepositInterest(int years) {
        double interest = balance * Math.pow((1 + interestRate / 100), years) - balance;
        balance += interest;
        System.out.println("Interest for " + years + " year(s): " + interest);
        System.out.println("Updated Balance after interest: " + balance);
    }

    // Withdraw money
    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal failed!");
        } else {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
            System.out.println("Updated Balance: " + balance);
        }
    }
}

// Derived class: Current Account
class CurAcct extends Account {
    double minimumBalance = 1000.0;
    double serviceCharge = 100.0;

    CurAcct(String name, int accNo, double bal) {
        super(name, accNo, "Current", bal);
    }

    // Withdraw money with minimum balance check
    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal failed!");
        } else {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
            checkMinimumBalance();
        }
    }

    // Check minimum balance and impose penalty if necessary
    void checkMinimumBalance() {
        if (balance < minimumBalance) {
            balance -= serviceCharge;
            System.out.println("Balance below minimum. Service charge of Rs." + serviceCharge + " imposed.");
        }
        System.out.println("Updated Balance: " + balance);
    }
}

// Main class: Bank
public class Bank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating sample accounts
        SavAcct sav = new SavAcct("Alice", 1001, 5000);
        CurAcct cur = new CurAcct("Bob", 2001, 1500);

        int choice;
        do {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit (Savings)");
            System.out.println("2. Withdraw (Savings)");
            System.out.println("3. Compute Interest (Savings)");
            System.out.println("4. Display Balance (Savings)");
            System.out.println("5. Deposit (Current)");
            System.out.println("6. Withdraw (Current)");
            System.out.println("7. Display Balance (Current)");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    sav.deposit(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    sav.withdraw(sc.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter number of years: ");
                    sav.computeAndDepositInterest(sc.nextInt());
                    break;
                case 4:
                    sav.displayBalance();
                    break;
                case 5:
                    System.out.print("Enter amount to deposit: ");
                    cur.deposit(sc.nextDouble());
                    break;
                case 6:
                    System.out.print("Enter amount to withdraw: ");
                    cur.withdraw(sc.nextDouble());
                    break;
                case 7:
                    cur.displayBalance();
                    break;
                case 8:
                    System.out.println("Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 8);

        sc.close();
    }
}
