import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
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
                }
        }
    }

