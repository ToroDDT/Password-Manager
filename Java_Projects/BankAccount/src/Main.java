import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ArrayList<Account> listOfAccounts = new ArrayList<Account>();
            int usersAdded = 0;
                while (usersAdded > 0) {
                    Scanner read = new Scanner(System.in);
                    System.out.print("Enter Account No:");
                    int accountNumber = read.nextInt();
                    System.out.print("Enter Account Type");
                    String accountType = read.nextLine();
                    System.out.print("Enter name");
                    String nameOfAccount = read.nextLine();
                    System.out.print("Enter Account starting balance");
                    int startingBalance = read.nextInt();
                    Account newAccount = new Account(accountNumber, accountType, nameOfAccount, startingBalance);
                    listOfAccounts.add(newAccount);
                }
                System.out.println("***Banking Application System***");
                System.out.println("1. Display all account details");
        System.out.println("2. Search by Account number");
        System.out.println("3. Deposit the amount");
        System.out.println("4. Withdraw the amount");
        System.out.println("Exit");
        System.out.println("Enter your choice:");
        Scanner read = new Scanner(System.in);
        int usersChoice = read.nextInt();
        }
    }

