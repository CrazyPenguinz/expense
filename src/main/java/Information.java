public class Information {
    private String type, detail;
    private double amount;

    public Information(String type, String detail, double amount) {
        this.amount = amount;
        this.type = type;
        this.detail = detail;
    }



    @Override
    public String toString() {
        String record = "";
        record += type + " : ";
        record += detail + " ";
        record += type.equals("Income")?"+" + amount:"-" + amount;
        return record;
    }
}
