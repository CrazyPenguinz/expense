public class Information {
    private String type, detail;
    private String amount;

    public Information(String type, String detail, String amount) {
        this.amount = amount;
        this.type = type;
        this.detail = detail;
    }

    public String getType() {
        return type;
    }

    public String getDetail() {
        return detail;
    }

    public String getAmount() {
        return amount;
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
