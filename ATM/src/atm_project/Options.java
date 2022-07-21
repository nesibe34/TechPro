package atm_project;

import java.text.DecimalFormat;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.Scanner;

public class Options extends Account{



    Scanner scan = new Scanner(System.in);

    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<>();

    boolean flag = true;

    public void login(){


        System.out.println("Hi! Welcome to Techproed ATM..");

        do {

            data.put(12345, 1234); //user 1
            data.put(23456, 2345); // user 2
            data.put(34567, 3456); // user 3
            data.put(45678,4567);  // user 4

            try {

                System.out.println("Enter account number");
                setAccountNumber(scan.nextInt());
                System.out.println("Enter the pin number");
                setPinNumber(scan.nextInt());

            }catch ( Exception e){
                System.out.println("Hey! You have entered an invalid character!");
                System.out.println("Please enter an integer to proceed or you can type in 'Q' to exit");
                String exit = scan.next().toLowerCase();
                if(exit.equals("q")){
                    flag = false;
                }
                e.printStackTrace();
            }

            int count = 0;
            for(Map.Entry<Integer, Integer> w : data.entrySet()){

                if(w.getKey().equals(getAccountNumber()) && w.getValue().equals(getPinNumber())){
                    System.out.println("Welcome to your account!");
                    int select=0;
                    while (select!=3) {
                        System.out.println("---------MENU---------");
                        System.out.println("Select the account you want to access");
                        System.out.println("1: Checking Account");
                        System.out.println("2: Saving Account");
                        System.out.println("3: Quit");
                        select = scan.nextInt();
                        switch (select) {
                            case 1:
                                int option = 0;
                                System.out.println("You are in Checking Account ");
                                while (option != 4) {
                                    System.out.println("Select option");
                                    System.out.println("1: View Balance");
                                    System.out.println("2: Withdraw");
                                    System.out.println("3: Deposit");
                                    System.out.println("4: Exit");
                                    option = scan.nextInt();
                                    switch (option) {
                                        case 1:
                                            System.out.println("Your current checking balance: " + moneyFormat.format(getCheckingBalance()));
                                            break;
                                        case 2:
                                            getCheckingWithdraw();
                                            break;
                                        case 3:
                                            getCheckingDeposit();
                                            break;
                                        case 4:
                                            System.out.println("You are redirected to the main menu...");
                                            break;
                                    }
                                }
                                break;
                            case 2:
                                int option2 = 0;
                                System.out.println("You are in Saving Account ");
                                while (option2 != 4) {
                                    System.out.println("Select option");
                                    System.out.println("1: View Balance");
                                    System.out.println("2: Withdraw");
                                    System.out.println("3: Deposit");
                                    System.out.println("4: Exit");
                                    option2 = scan.nextInt();
                                    switch (option2) {
                                        case 1:
                                            System.out.println("Your current saving balance: " + moneyFormat.format(getSavingBalance()));
                                            break;
                                        case 2:
                                            getSavingWithdraw();
                                            break;
                                        case 3:
                                            getSavingDeposit();
                                            break;
                                        case 4:
                                            System.out.println("You are redirected to the main menu...");
                                            break;
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("Goodbye...");
                                break;
                        }
                    }
                }else{
                    count++;
                }
            }
            if(count == data.size()){
                System.out.println("Account number or pin number does not match our users");
                System.out.println("invalid User");
                System.out.println("Press any integer to try again or Press 'Q' to exit");
                String exit = scan.next();
                if(exit.equalsIgnoreCase("q")){
                    flag = false;
                }
            }
        }while (flag );



    }
    public static void showMenu(){

    }


}