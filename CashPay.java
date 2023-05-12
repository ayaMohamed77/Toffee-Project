import java.util.*;
/** This class represents a cash payment.
 * @author Aya Mohamed Abdelrahman
 *          Karin Khier Abdallah
 *          Alaa Elbasyonee Abdelaal
 * @version 1.0
 * @since 8/5/2023
 */
public class CashPay extends Payment {
    private
    /** Amount of cash given */
    float cash;
    /** Amount of change due */
     float rest;
    /** A constructor to intialize a cash object
     * @param amount is the due amount to be paid from this cash
     */

     public CashPay(Float amount){
         Scanner input = new Scanner(System.in);
         System.out.println("Please enter your Cash:");
         cash=input.nextFloat();
         setAmount(amount);
     }

    /**
     * check if change exist or not
     * @return true if exist and
     * false otherwise
     */

    public boolean rest() {
        rest = cash - getAmount();
        return (rest >=0);
    }

    /** Display a message saying if payment
     * was successful (cash larger than or equal due amount)
     * or not
     */
    public void displayMessage () {
        rest();
        if (rest >=0)
            System.out.println(" You paid: " + cash + " and change: " + rest + " Successful Cash Payment");
        else
           System.out.println("You paid: " + cash + " but required amount is: " + getAmount()+ "Unsuccessful Cash Payment");
    }
}
