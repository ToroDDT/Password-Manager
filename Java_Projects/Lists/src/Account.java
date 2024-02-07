public class Account {
    private int balance;
    private String name;

    public Account (int balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    public void addFunds (int amount) {
        this.balance = balance + amount;
    };

    public void withdrawFunds (int amount) {
       this.balance = balance - amount;
    }

    public void nameOfAccount () {
        System.out.println(this.balance);
    }

}
