import java.util.*;
import java.util.regex.Pattern;

/** This class represents a payment for an order
 * with credit card
 *  * @author Aya Mohamed Abdelrahman
 *  *          Karin Khier Abdallah
 *  *          Alaa Elbasyonee Abdelaal
 * @version 1.0
 * @since 8/5/2023
 */

public class Credit extends Payment {
    private String cardNumber;
    private String cardType;
    private int expiryMonth;
    private cardStatus cardStatus;
    boolean Active;

    /** take Card information from user
     * @param amount take order amount
     */

    public Credit(Float amount){
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your Card Num :");
        cardNumber=input.nextLine();
        System.out.println("Please enter your Card type :");
        cardType=input.nextLine();
        System.out.println("Please enter your Card Expiry month:");
        expiryMonth=input.nextInt();
        setAmount(amount);

        Active=Pattern.matches("\\d{14}",cardNumber);
        int currentMonth=5; //May
        if(expiryMonth<currentMonth ||expiryMonth>12) // if Card expired date is before our current month
            cardStatus = cardStatus.EXPIRED;
        else if (!Active)
            cardStatus= cardStatus.INACTIVE;
        else
            cardStatus= cardStatus.ACTIVE;
    }


    /** Displays a message if credit card payment
     * was successful or not (InActive, expired ).
     * If Card Num != 14 num card is inactive, if expirymonth != 5 or any larger num card is expired
     * otherwise card is valid.
     */
    public void displayMessage () {
        Active=Pattern.matches("\\d{14}",cardNumber);
        if (!Active)
          System.out.println("I could not process your card payment - " + cardStatus +
                  " Unsuccessful Card Payment");
        else{
            System.out.println("You paid: " + getAmount() + " by Credit Card Successful Card Payment");

    }
    }
}
