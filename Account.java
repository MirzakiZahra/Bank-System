import MyDate.MyDate;

import java.util.Date;

public class Account {
    private String name;
    private MyDate data_of_begin;
    private double inventory;
    private long id;
    protected Transaction []transaction= new Transaction[100];
    protected int index_of_transaction=0;

    public int getIndex_of_transaction() {
        return index_of_transaction;
    }

    public void setIndex_of_transaction(int index_of_transaction) {
        this.index_of_transaction = index_of_transaction;
    }

    public Transaction[] getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction[] transaction) {
        this.transaction = transaction;
    }


    public Account() {
    }

    public Account(String name, MyDate data_of_begin, int inventory) {
        this.name = name;
        this.data_of_begin = data_of_begin;
        this.inventory = inventory;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyDate getData_of_begin() {
        return data_of_begin;
    }

    public void setData_of_begin(MyDate data_of_begin) {
        this.data_of_begin = data_of_begin;
    }

    public double getInventory() {
        return inventory;
    }

    public void setInventory(double inventory) {
        this.inventory = inventory;
    }
    public void removal(int fund, MyDate date, String type) {
        if (fund <= this.inventory) {
            double temp = this.getInventory() - fund;
            this.setInventory(temp);
            this.transaction[index_of_transaction].setDate(date);
            this.transaction[index_of_transaction].setFee(fund);
            this.transaction[index_of_transaction].setType(type);
            this.index_of_transaction++;

        } else {
            System.out.println("not enough inventory");
        }
    }
    public void settle(int fund, MyDate date, String type){
        double temp=this.getInventory()+fund;
        this.setInventory(temp);
        this.transaction[index_of_transaction].setDate(date);
        this.transaction[index_of_transaction].setFee(fund);
        this.transaction[index_of_transaction].setType(type);
        this.index_of_transaction++;

    }
    public void interest(Date date){

    }
    public void set_transaction(Transaction transaction){
        this.transaction[index_of_transaction] = transaction;
        index_of_transaction++;
    }
}
