import MyDate.MyDate;


public class Customer {
    Account[] accounts = new Account[50];
    public Customer(){
        for(int i =0; i<50;i++){
            accounts[i] = new Account();
        }

    }


    int account_index = 0;
    private String name;
    private String family;
    private int id;



    public int getAccount_index() {
        return account_index;
    }

    public void setAccount_index(int account_index) {
        this.account_index = account_index;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void request(String name, long id, int fund, MyDate mydate, Maneger maneger, String request_type, Customer[] customer_array) {
        if (request_type.equalsIgnoreCase(Transaction_type.DEPOSIT.getAbbr())) {
            maneger.deposit(id, fund, mydate, customer_array);
        }
        if (request_type.equalsIgnoreCase(Transaction_type.WITHDRAW.getAbbr())) {
            maneger.withdraw(id, fund, mydate, customer_array);
        }
    }
    public  void request_loan(long id, int fund, int period, MyDate mydate){
            for (int i =0; i<this.account_index; i++){
                if (this.accounts[i].getId() == id){
                    double temp= this.accounts[i].getInventory()+fund;
                    this.accounts[i] = (Loan_account) this.accounts[i];
                    this.accounts[i].setInventory(temp);
                    ((Loan_account) this.accounts[i]).setLoan_date_begin(mydate);
                    ((Loan_account) this.accounts[i]).setLoan_amount(fund);
                    ((Loan_account) this.accounts[i]).setLoan_month(period);
                    ((Loan_account) this.accounts[i]).setLoan_interest(0.1);
                    ((Loan_account) this.accounts[i]).setPayment(fund/period);
                }
            }

    }


}
