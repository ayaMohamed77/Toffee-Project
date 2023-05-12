/** This is an abstrat class of payment.
 */
public abstract class Payment {
    private float amount;

    /**
     * default constructor
     */
    public Payment(){}
    /** constructor sets the amount to be paid
     * @param amount - is the amount to be paid
     */
    public Payment (float amount) {
        this.amount = amount;
    }
    public void setAmount (float amount) {
        this.amount = amount;
    }
    /** get the amount to be paid
     * @return the mount that needs to be paid.
     */
    public float getAmount () {
        return amount;
    }
    /** Display a message showing payment success
     * or failure
     */
    public abstract void displayMessage ();
}