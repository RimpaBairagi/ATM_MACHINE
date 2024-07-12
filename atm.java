import java.util.ArrayList;
import java.util.Scanner;

public class atm {
    int pin=79800;
    public double Balance;
    public ArrayList<String> transactionHistory;
    public atm() {
        Balance = 0.0;
        transactionHistory = new ArrayList<>();
    }

    public void menu(){

        System.out.println("............MENU...............");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdrawl");
        System.out.println("3. Deposit");
        System.out.println("4. Pin Change");
        System.out.println("5. Pritn Transaction History");
        System.out.println("6. Exit");
        System.out.println("Enter Your Choice");

        Scanner input= new Scanner(System.in);
        int no = input.nextInt();
        if(no==1){
            check_balance();

        }
        else if(no==2){
            withdrawl();
        }
        else if(no==3){
            deposit();
        }
        else if(no==4){
           System.out.println("Ente Your New Pin: ");
           Scanner pin_no = new Scanner(System.in);
           int p = pin_no.nextInt();
           pin = p;
           menu();
        }
        else if(no==5){
            printTransactionHistory();
        }
            
        
        else if(no==6){
            System.out.println("Please remove your card!");
            System.exit(0);
        }
        else{
           System.out.println("Enter a valid choice!");
           menu();
        }
    
    }
    public void pin_check(int pin){
        if (this.pin==pin){
            System.out.println("Balance"+Balance);
        }
        else{
            System.out.println("Invalid pin");
            menu();
        }
        

    }
    public void check_balance(){
        System.out.println("Enter your pin");
        Scanner in = new Scanner(System.in);
        int pin= in.nextInt();
        pin_check(pin);
        menu();

    }
    public void withdrawl(){
        System.out.println("Enter your pin");
        Scanner in = new Scanner(System.in);
        int pin= in.nextInt();
        pin_check(pin);
        System.out.println("Enter Your amount");
        Scanner inp = new Scanner(System.in);
        float width = inp.nextFloat();
        if(width>Balance){
            System.out.println("Insufficient money");
        }
        else{
            Balance= Balance-width;
            transactionHistory.add("Withdrew: $" + width);
        System.out.println("Money withdraw successfully");
        }
        menu();
       

    }
    public void deposit(){
        System.out.println("Enter your pin");
        Scanner in = new Scanner(System.in);
        int pin= in.nextInt();
        pin_check(pin);
        System.out.println("Enter Your amount");
        Scanner inp = new Scanner(System.in);
        float dep = inp.nextFloat();
        Balance= Balance + dep;
        transactionHistory.add("Deposited: $" + dep);
        System.out.println("Money deposited sucessfully");
        menu();


    }
    public void printTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            System.out.println("..........Transaction History...........:");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }
    
   
    }
    

    
    

