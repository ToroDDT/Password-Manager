public class Account {
    private int accountNumber = 0;
    private String AccountType = "savings";
    private  String name = "";
    private int balance = 0;

    public Account (int accountNumber, String AccountType, String name, int balance) {
        this.accountNumber = accountNumber;
        this.AccountType = AccountType;
        this.name = name;
        this.balance = balance;

        }
        public int accountBalance () {
            return this.balance;
        };

    public void deposit (int amount ) {
        int newBalance = this.balance + amount;
    }

    public void withdraw (int amount ){
        int newBalance = this.balance - amount;
    }


    }

    // Display Welcome message
    // Ask whether they want to create an account
    // if yes
    // display enter Account Number
    // display the following
        //name
        // balance
        // Account
        // Account type
        //