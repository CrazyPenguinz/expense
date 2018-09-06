import java.util.ArrayList;

public class Book {
    private ArrayList<Information> book;
    private double balance;

    public Book() {
        balance = 0;
        book = new ArrayList<>();
    }

    public Book(double initBalance) {
        this.balance = initBalance;
        book = new ArrayList<>();
    }

    public void receive(String detail, double amount) {
        book.add(new Information("Income", detail, amount));
        balance += amount;
    }

    public void pay(String detail, double amount) throws OverExpenseException {
        book.add(new Information("Expense", detail, amount));
        balance -= amount;
        if (amount > balance) {
            throw new OverExpenseException("Be Careful! your expense more than your balance\n");
        }
    }


    public double getBalance() {
       return balance;
    }

    public String getRecord() {
        String tmp = "";
        if (!book.isEmpty()) {
            for (Information i : book) {
               tmp += i.toString();
            }
            tmp += "\nBalance : " + getBalance() + "\n";
        }
        else {
            tmp += "No Information. Please enter an event.\n";
        }
        return tmp;
    }
}
