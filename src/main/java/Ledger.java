//public class Ledger {
//    private int stage;
//    private Book book;
//
//    public static final int TRANSACT = 2;
//
//    public Ledger() {
//        book = new Book();
//        stage = TRANSACT;
//    }
//
//    public Ledger(Book book) {
//        this.book = book;
//        stage = TRANSACT;
//    }
//
//    public void receive(String detail, double amount) {
//        if (stage == TRANSACT) {
//            book.receive(detail, amount);
//        }
//    }
//
//    public void pay(String detail, double amount) throws OverExpenseException {
//        if (stage == TRANSACT) {
//            book.pay(detail, amount);
//        }
//    }
//
//    public double getBalance() {
//        if (stage == TRANSACT) {
//            return book.getBalance();
//        }
//        return -1;
//    }
//
//    public String getRecord() {
//        return book.getRecord();
//    }
//
//    public int getStage() {
//        return stage;
//    }
//}
