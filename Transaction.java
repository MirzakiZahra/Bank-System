import MyDate.MyDate;

public class Transaction {
    private MyDate date;
    private double fee;
    private String type;

    public MyDate getDate() {
        return date;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }

    public Transaction(MyDate date, double fee, String type) {
        this.date = date;
        this.fee = fee;
        this.type = type;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
