import MyDate.MyDate;

public class Checkig_account  extends Account {
    public Checkig_account(String name, MyDate data_of_beggin, int inventory) {
        super(name, data_of_beggin, inventory);
    }

    public Checkig_account() {
    }

    @Override
    public void removal(int fund, MyDate date, String type) {
        if (fund <= 2000000 && fund<=this.getInventory()) {
            double temp = this.getInventory() - fund - 700;
            this.setInventory(temp);
            this.transaction[index_of_transaction].setDate(date);
            this.transaction[index_of_transaction].setType("f");
            this.transaction[index_of_transaction].setFee(700);
            index_of_transaction++;
        } else {
            System.out.println("error");
        }
    }

    @Override
    public void settle(int fund, MyDate date, String type) {
        super.settle(fund, date, type);
    }
}


