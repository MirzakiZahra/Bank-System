import MyDate.MyDate;

public class Savin_account extends Account {
    public Savin_account() {
    }

    public Savin_account(String name, MyDate data_of_beggin, int inventory) {
        super(name, data_of_beggin, inventory);
    }

    @Override
    public void removal(int fund, MyDate date, String type) {
        super.removal(fund, date, type);
    }

    @Override
    public void settle(int fund, MyDate date, String type) {
        super.settle(fund, date, type);
    }
}
