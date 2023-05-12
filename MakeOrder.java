import java.io.*;
import java.util.*;

/** This class represents making order process
 *  * @author Aya Mohamed Abdelrahman
 *  *          Karin Khier Abdallah
 *  *          Alaa Elbasyonee Abdelaal
 * @version 1.0
 * @since 8/5/2023
 */
public class MakeOrder {
    private List<String> Cart = new ArrayList<>();
    /**
     * pay variable to check if user paid
     */
    public boolean Pay;


    /**
     * Keep track with new modifications
     * @param products
     */
    private static void saveToFile(List<String> products, String filePath) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filePath));
            for (String product : products) {
                writer.write(product);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Print items in menu
     */
    public void ShowMenu() {
        try {
            File menu = new File("\\D:\\Codes\\java\\Toffee\\items.txt\\");
            Scanner myReader = new Scanner(menu);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * take info from user to make his order
     */
    public void Makeorder() {
        String Address, item;
        int Choice, paymentMethod;
        Float amount;
        Random r = new Random();
        amount = r.nextFloat(100);
        System.out.println("Please enter Your Address :- ");
        Scanner Read = new Scanner(System.in);
        Address = Read.nextLine();
        System.out.println("Please Choose items from menu OR press (E)xit to exit :-");
        ShowMenu();
        System.out.println("Enter the name of the product to add:");
        item = Read.nextLine();
        while (!item.equals("e")) {
            Cart.add(item);
            System.out.println("Enter the name of the product to add OR (E)xit to exit:");
            item = Read.nextLine().toLowerCase();
        }
        saveToFile(Cart, "\\D:\\Codes\\java\\Toffee\\UserCart.txt\\");
        System.out.println("The products have been added successfully. Your receipt = " + amount +
                " Want to 1)pay or \n2)View cart ?");
        Choice = Read.nextInt();
        Pay = false;
        while (!Pay) {
            switch (Choice) {
                case (1):
                    System.out.println("Want to Pay 1)Credit \n 2)Cash :-");
                    paymentMethod = Read.nextInt();
                    switch (paymentMethod) {
                        case (1):
                            Credit mycredit = new Credit(amount);
                            mycredit.displayMessage();
                            if (!mycredit.Active) {
                                Pay = false;
                            } else
                                Pay = true;
                            break;
                        case (2):
                            CashPay myPay = new CashPay(amount);
                            myPay.displayMessage();
                            if (!myPay.rest())
                                Pay = false;
                            else
                                Pay = true;
                            break;
                        default:
                            System.out.println("Invalid Choice .");
                    }
                    break;
                case (2):
                    System.out.println(Cart);
                    Pay = false;
                    System.out.println("Your receipt = " + amount + " Want to pay or View cart ?");
                    Choice = Read.nextInt();
                    break;
                default:
                    System.out.println("Invalid Choice .");
            }

        }
        Order myOrder = new Order(amount, Address, 20, 1, orderstatus.NEW);
    }

    /**
     * cancel user orders
     */
    public void CancelOrder() {
        if (Cart.isEmpty()) {
            System.out.println("Your Cart is already Empty ");
        } else {
            System.out.println("The order is Canceled Successfully ");
        }
    }
}

