import MyDate.MyDate;

import java.util.Date;

public class Loan_account extends Account {
    private int loan_amount;//// مبلغ وام
    private int loan_month;
    private double loan_interest;
    private double payment;
    private MyDate loan_date_begin;
    private int number_of_paidpayment=0;

    public int getNumber_of_paidpayment() {
        return number_of_paidpayment;
    }

    public void setNumber_of_paidpayment(int number_of_paidpayment) {
        this.number_of_paidpayment = number_of_paidpayment;
    }

    public MyDate getLoan_date_begin(MyDate mydate) {
        return loan_date_begin;
    }

    public void setLoan_date_begin(MyDate loan_date_begin) {
        this.loan_date_begin = loan_date_begin;
    }

    public int getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(int loan_amount) {
        this.loan_amount = loan_amount;
    }

    public int getLoan_month() {
        return loan_month;
    }

    public void setLoan_month(int loan_month) {
        this.loan_month = loan_month;
    }

    public double getLoan_interest() {
        return loan_interest;
    }

    public void setLoan_interest(double loan_interest) {
        this.loan_interest = loan_interest;
    }

    public MyDate getLoan_date_begin() {
        return loan_date_begin;
    }



    public Loan_account(int loan_amount, int loan_month, double loan_interest, double payment, MyDate loan_date_begin) {
        this.loan_amount = loan_amount;
        this.loan_month = loan_month;
        this.loan_interest = loan_interest;
        this.payment = payment;
        this.loan_date_begin = loan_date_begin;
    }

    public Loan_account(String name, MyDate data_of_begin, int inventory, int loan_amount, int loan_month, double loan_interest, double payment, MyDate loan_date_begin) {
        super(name, data_of_begin, inventory);
        this.loan_amount = loan_amount;
        this.loan_month = loan_month;
        this.loan_interest = loan_interest;
        this.payment = payment;
        this.loan_date_begin = loan_date_begin;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public Loan_account() {
        super();
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
