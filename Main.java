import MyDate.MyDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Maneger maneger=new Maneger();
        //Customer []customer = new Customer[100];
        /*for (int i=0; i<100; i++){
            customer[i] = new Customer();
        }*/
        //int customer_index =0;
        Scanner scanner=new Scanner(System.in);
        int choice=0;
        MyDate mydate = new MyDate(1400,01,01);
        System.out.println("************Welcome****************");
        do {
            System.out.println("1.Admin\n 2.Customer\n 3.Exit");
            choice = scanner.nextInt();
            int customer_choice=0;
            int admin_choice=0;
            do {
                switch (choice) {
                    case 1:
                        System.out.println("welcome admin");
                        System.out.println("1.Add new account\n2.view account\n3.withdraw\n4.deposit\n5.calculate interest\n6.view transaction\n7.exit");
                        System.out.println("Select a Choice:");
                        admin_choice = scanner.nextInt();
                        switch (admin_choice){
                            case 1:
                                System.out.println("Enter name, family, fund,  type");
                                maneger.Add_new_account(maneger.customer,maneger.customer_index,scanner.next(),scanner.next(),scanner.nextInt(),mydate,scanner.next());


                                break;
                            case 2:
                                System.out.println("Please Enter Name");
                                maneger.View_accounts(scanner.next(), maneger.customer,maneger.customer_index);
                                break;
                            case 3:
                                System.out.println("Please Enter id, fund, date");
                                maneger.withdraw(scanner.nextLong(),scanner.nextInt(),mydate,maneger.customer);
                                break;
                            case 4:
                                System.out.println("Please Enter id, fund, date");
                                maneger.deposit(scanner.nextLong(),scanner.nextInt(),mydate,maneger.customer);
                                break;
                            case 5:
                                System.out.println("Please Enter id, type(l or s), date, next_date(today,nextday,nextmonth)");
                                maneger.calculate_interest(scanner.nextInt(),scanner.next(),maneger.customer,mydate,scanner.next());
                                break;
                            case 6:
                                System.out.println("Please Enter ID");
                                maneger.View_transaction(scanner.nextLong(),maneger.customer);
                                break;
                            case 7:
                                break;
                        }
                    break;
                    case 2:
                        System.out.println("welcome customer");
                        System.out.println("1.request\n2.loan_request\n3.Exit");
                        customer_choice=scanner.nextInt();
                        switch (customer_choice){
                            case 1:
                                System.out.println("Please Enter your name");
                                String name = scanner.next();
                                for (int i =0;i<maneger.customer_index;i++){
                                    if (maneger.customer[i].getName() == name){
                                        System.out.println("Please Enter id, fund, request type(w,d)");
                                        maneger.customer[i].request(name, scanner.nextLong(),scanner.nextInt(),mydate,maneger,scanner.next(),maneger.customer);
                                        break;
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("Please Enter your name");
                                name = scanner.next();
                                for (int i =0;i<maneger.customer_index;i++){
                                    if (maneger.customer[i].getName() == name){
                                        System.out.println("Please Enter ID,Fund,Period");
                                        maneger.customer[i].request_loan(scanner.nextLong(),scanner.nextInt(),scanner.nextInt(),mydate);
                                        break;
                                    }
                                }
                                break;
                            case 3:
                                break;

                        }
                    break;

                }
            }while (customer_choice !=3 && admin_choice !=7);
        }while (choice != 3);




    }


}
