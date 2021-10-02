import java.util.Date;
import java.util.Random;
import MyDate.MyDate;


public class Maneger {
    private int[] reserved_id = new int[5000];
    private int index_of_reserved_id = 0;
    Random random_generator = new Random();
    Customer[] customer= new Customer[100];
    Customer customer(){
        for (int i=0; i<100; i++){
            customer[i] = new Customer();
        }
        return null;
    }

    int customer_index=0;
    //Transaction transaction=new Transaction();

    // Customer customer=new Customer();

    //  public Customer[] getCustomer() {
    //    return customer;
    //}

    //public void setCustomer(Customer[] customer) {
    //   this.customer = customer;
    //}

    public void Add_new_account(Customer[] customer_array, int customer_index, String name, String family, int fund, MyDate date, String type) {
        int indicator = 0;
        if (type.equalsIgnoreCase(Account_Type.CHECKING_ACCOUNT.getAbbr())) {
            for (int i = 0; i < customer_index; i++) {
                if (customer_array[i].getName() == name) {
                    int index = customer_array[i].getAccount_index();
                    customer_array[i].accounts[index] = new Checkig_account();
                    this.Create_new_account(customer_array, customer_index, index, fund, date);
                    indicator++;
                    break;
                }

            }
            if (indicator == 0) {
                this.customer[this.customer_index]=new Customer();
                this.customer[this.customer_index].setName(name);
                this.customer[this.customer_index].setFamily(family);
                int index = this.customer[this.customer_index].getAccount_index();
                this.customer[this.customer_index].accounts[index]=new Checkig_account();
                this.Create_new_account(this.customer, this.customer_index, index, fund, date);
                this.customer_index = this.customer_index+1;
                System.out.println(this.customer_index);

                /*customer_array[customer_index].setName(name);
                customer_array[customer_index].setFamily(family);
                int index = customer_array[customer_index].getAccount_index();
                customer_array[customer_index].accounts[index] = new Checkig_account();
                this.Create_new_account(customer_array, customer_index, index, fund, date);
                this.customer_index = this.customer_index+1;*/

            }
        }
        if (type.equalsIgnoreCase(Account_Type.LOAN_ACCOUNT.getAbbr())) {
            indicator = 0;
            for (int i = 0; i < customer_index; i++) {
                if (customer_array[i].getName() == name) {
                    int index = customer_array[customer_index].getAccount_index();
                    customer_array[customer_index].accounts[index] = new Loan_account();
                    this.Create_new_account(customer_array, customer_index, index, fund, date);
                    indicator++;
                    break;
                }

            }
            if (indicator == 0) {

                customer_array[customer_index].setName(name);
                customer_array[customer_index].setFamily(family);
                int index = customer_array[customer_index].getAccount_index();
                customer_array[customer_index].accounts[index] = new Loan_account();
                this.Create_new_account(customer_array, customer_index, index, fund, date);
                this.customer_index = this.customer_index+1;

            }
        }
        if (type.equalsIgnoreCase(Account_Type.SAVING_ACCOUNT.getAbbr())) {
            indicator = 0;
            for (int i = 0; i < customer_index; i++) {
                if (customer_array[i].getName() == name) {
                    int index = customer_array[customer_index].getAccount_index();
                    customer_array[customer_index].accounts[index] = new Savin_account();
                    this.Create_new_account(customer_array, customer_index, index, fund, date);
                    indicator++;
                    break;
                }

            }
            if (indicator == 0) {

                customer_array[customer_index].setName(name);
                customer_array[customer_index].setFamily(family);
                int index = customer_array[customer_index].getAccount_index();
                customer_array[customer_index].accounts[index] = new Savin_account();
                this.Create_new_account(customer_array, customer_index, index, fund, date);
                this.customer_index++;

            }
        }
    }

    public void Create_new_account(Customer[] customer_array, int customer_index, int index, int fund, MyDate date) {
        this.customer[this.customer_index].accounts[index].setInventory(fund);
        this.customer[this.customer_index].accounts[index].setData_of_begin(date);

        //customer_array[customer_index].accounts[index].setInventory(fund);
        //customer_array[customer_index].accounts[index].setData_of_begin(date);
        int id = valid_random_number(999999, 100000);
        this.customer[this.customer_index].accounts[index].setId(id);
        //customer_array[customer_index].accounts[index].setId(id);
        index++;
        this.customer[this.customer_index].setAccount_index(index);
        //customer_array[customer_index].setAccount_index(index);
    }

    public int valid_random_number(int max, int min) {
        int indicator = 0;
        int random = 0;
        while (indicator == 0) {
            random = min + random_generator.nextInt(max - min);
            for (int i = 0; i < this.index_of_reserved_id; i++) {
                if (random == reserved_id[i]) {
                    break;
                }
            }
            reserved_id[index_of_reserved_id] = random;
            indicator = 1;
            index_of_reserved_id++;
        }
        return random;

    }


    public void View_accounts(String name, Customer[] customer_array, int index_of_customer) {
        for (int i = 0; i < this.customer_index; i++) {
            if (this.customer[i].getName() == name) {
                for (int j = 0; j < this.customer[i].account_index; j++) {
                    System.out.println("name:" + " " + this.customer[i].accounts[j].getName() +
                            " " + "date of begin:" + " " + this.customer[i].accounts[j].getData_of_begin().toString() +
                            " " + "Inventory:" + " " + this.customer[i].accounts[j].getInventory());
                }

            }
        }


    }

    public void View_transaction(long id, Customer[] customer_array) {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < customer_array[i].account_index; j++) {
                if (customer_array[i].accounts[j].getId() == id) {
                    for (int k = 0; k < customer_array[i].accounts[j].getIndex_of_transaction(); k++)
                        System.out.println("Date:" + " " + customer_array[i].accounts[j].getTransaction()[k].getDate() + " " +
                                "Fee:" + " " + customer_array[i].accounts[j].getTransaction()[k].getFee() + " " +
                                "Type:" + " " + customer_array[i].accounts[j].getTransaction()[k].getType() + " ");
                }
            }
        }


    }

    public void deposit(long id, int fund, MyDate mydate, Customer[] customer_array) {
        int indicator = 0;
        String deposit = "d";
        for (int i = 0; i < customer_array.length; i++) {
            for (int j = 0; j < customer_array[i].getAccount_index(); j++) {
                if (id == customer_array[i].accounts[j].getId()) {
                    customer_array[i].accounts[j].settle(fund, mydate, deposit);
                    indicator++;
                    break;
                }
            }
            if (indicator == 0) {
                System.out.println("ID is Wrong");
            }

        }
    }

    public void withdraw(long id, int fund, MyDate mydate, Customer[] customer_array) {
        int indicator = 0;
        String withdraw = "w";
        for (int i = 0; i < customer_array.length; i++) {
            for (int j = 0; j < customer_array[i].getAccount_index(); j++) {
                if (id == customer_array[i].accounts[j].getId()) {
                    customer_array[i].accounts[j].removal(fund, mydate, withdraw);
                    indicator++;
                    break;
                }
                if (indicator == 0) {
                    System.out.println("ID is Wrong");
                }
            }
        }
    }
        public void calculate_interest ( int id, String type, Customer[]customer_array, MyDate date, String nextdate){
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < customer_array[i].account_index; j++) {
                    if (customer_array[i].accounts[j].getId() == id) {
                        if (type.equalsIgnoreCase(Account_Type.LOAN_ACCOUNT.getAbbr())) {
                            customer_array[i].accounts[j] = (Loan_account) customer_array[i].accounts[j];
                            double interest = (((Loan_account) customer_array[i].accounts[j]).getLoan_interest() *
                                    ((Loan_account) customer_array[i].accounts[j]).getLoan_amount());
                            double temp = customer_array[i].accounts[j].getInventory() -
                                    ((Loan_account) customer_array[i].accounts[j]).getPayment() -
                                    interest;
                            customer_array[i].accounts[j].setInventory(temp);
                            int temp1 = ((Loan_account) customer_array[i].accounts[j]).getNumber_of_paidpayment() + 1;
                            ((Loan_account) customer_array[i].accounts[j]).setNumber_of_paidpayment(temp1);
                            Transaction transaction = new Transaction(date, interest, "i");
                            customer_array[i].accounts[j].set_transaction(transaction);
                            switch (nextdate) {
                                case "today":
                                    date = date;
                                    break;
                                case "nextday":
                                    date.nextDay();
                                    break;
                                case "nextmonth":
                                    date.next_month();
                                    break;
                            }
                        }
                        if (type.equalsIgnoreCase(Account_Type.SAVING_ACCOUNT.getAbbr())) {
                            customer_array[i].accounts[j] = (Savin_account) customer_array[i].accounts[j];
                            double interest = customer_array[i].accounts[j].getInventory() * 0.1;
                            double temp = customer_array[i].accounts[j].getInventory() +
                                    interest;
                            customer_array[i].accounts[j].setInventory(temp);
                            Transaction transaction = new Transaction(date, interest, "i");
                            customer_array[i].accounts[j].set_transaction(transaction);
                            switch (nextdate) {
                                case "today":
                                    date = date;
                                    break;
                                case "nextday":
                                    date.nextDay();
                                    break;
                                case "nextmonth":
                                    date.next_month();
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }
