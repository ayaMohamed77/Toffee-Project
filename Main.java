/**
 *  * @author Aya Mohamed Abdelrahman
 *  *          Karin Khier Abdallah
 *  *          Alaa Elbasyonee Abdelaal
 * @version 1.0
 * @since 8/5/2023
 */
import java.io.IOException;
import java.util.Scanner;

//please enter your file path in makeorder class && Product class

public class Main {
    /** This is the main method.
     * It is for testing purposes to test
     * the work of Toffee Store program.
     */
    public static void main(String[] args) {
        //the main file to run Toffee file
        Scanner input = new Scanner(System.in);
        String name, email, password, suggestion;
        UserAccount myUser = new UserAccount();
        System.out.println("Welcome To Toffee Store:");
        System.out.println(" Want to Register to our System -> 1:");
        System.out.println(" Already have an account ? Login -> 2:");
        System.out.println(" Enter your Choice :");
        int LRchoice = input.nextInt();

        if (LRchoice == 1){ // if user not have an account in Toffee Store
            input.nextLine();
            System.out.print("Enter your Name:\n");// take information
            name = input.nextLine();
            System.out.print("Enter your Email:\n");
            email = input.nextLine();

            while (!myUser.RegexMail(email)){ // regex code to check if valid mail
                System.out.println("Your Mail does not meet the standard ,Please enter Right one ");//standard mail should have char(s) number(s) and (@) char and .com at the end
                email = input.nextLine();
            }
            System.out.print("Enter your Password:\n");
            password = input.nextLine();

            while (!myUser.RegexPass(password)){ // standard Password should have char(s) number(s) and 1st char should be Uppercase
                System.out.println("Your Password does not meet the standard \n \"Please make The first letter Uppercase and add some numbers\" \n " +
                        "Please make Right one");
                password = input.nextLine();
            }

            myUser.register(name,password,email);

            LRchoice=2; // now he can login.

        }
        /**
         * This for Users who have accounts already
         * or after nwe user register
         */
 if (LRchoice == 2) { // if have An account already or have been register now.
     System.out.println("1) User Account \n 2) Admin Account ");
     int AccountType = input.nextInt();
     input.nextLine(); // consume the newline character left in the input stream
     System.out.println("Enter your Name:");
     name = input.nextLine();
     System.out.println("Enter your Password:");
     password = input.nextLine();
     myUser.login(name, password);
     switch (AccountType) { // each type has its own functions.
         case (1):
             System.out.println("\nNow You are in Toffee main Page What do you Want to do : \n 1) Show Menu \n"
                     + "2) Make an order \n3) Canceling an Order \n4) Show Your Account information \n" +
                     "5) Rate Us Or Submit suggestions and complaints \n 6) Exit: ");
             int choice;
             choice = input.nextInt();
             MakeOrder reader = new MakeOrder();
             while (choice <= 6) {
                 switch (choice) {
                     case (1):
                         reader.ShowMenu();
                         break;
                         case (2):
                             reader.Makeorder();
                             break;
                         case (3):
                             reader.CancelOrder();
                             break;
                         case (4):
                             myUser.PrintInfo();
                             break;
                         case (5):
                             System.out.println("Please enter your Suggestions : -");
                             suggestion = input.nextLine();
                             break;
                         case (6):
                             System.out.println("Exiting Toffee Store.......");
                             break;
                         default:
                             System.out.println("Invalid choice ");
                 }

                 if (choice == 6)
                     break;
                 System.out.println("\n What do you Want to do now : \n 1) Show Menu \n 2) Make an order \n" +
                         " 3) Canceling an Order \n 4) Show Your Account information \n" +
                         "5) Rate Us Or Submit suggestions and complaints \n 6) Exit: ");
                 choice = input.nextInt();
             }
             break;
             case (2):
                 try {
                     Product Admain = new Product();
                     System.out.println("\nNow You are in Toffee main Page What do you Want to do : \n 1) Show Menu \n 2) Add a Product\n" +
                             " 3) Modify a Product \n" + " 4) Remove a Product \n 5) Exit :");
                     choice = input.nextInt();

                     while (choice <= 5) {
                         switch (choice) {
                             case (1):
                                 Admain.ShowMenu();
                                 break;
                             case (2):
                                 Admain.addProduct();
                                 break;
                             case (3):
                                 Admain.modifyProduct();
                                 break;
                             case (4):
                                 Admain.deleteProduct();
                                 break;
                             case (5):
                                 break;
                             default:
                                 System.out.println("Invalid Choice.");
                         }
                         if (choice == 5)
                             break;
                         System.out.println("\n What do you Want to do now : \n 1) Show Menu \n 2) Add a Product\n" +
                                 " 3) Modify a Product \n 4) Remove a Product \n 5) Exit :");
                         choice = input.nextInt();
                     }
                 }
                 catch (IOException e){
                     e.printStackTrace();
                 }
                 break;
             default:
                 System.out.println("Invalid Choice");
     }
 }
    }
}
