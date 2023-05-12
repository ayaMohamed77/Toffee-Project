/** This class represents an order
 *  * @author Aya Mohamed Abdelrahman
 *  *          Karin Khier Abdallah
 *  *          Alaa Elbasyonee Abdelaal
 * @version 1.0
 * @since 8/5/2023
 */

public class Order {
    private float orderTotal;
    private String deliveryAddress;
    private float taxPercentage;
    private int orderId;
    private orderstatus status;

    // Parameterized constructor

    /**
     * constructor requires tax rate applicabl
     * to the order
     * @param taxPercentage the applicable tax rate
     * @param deliveryAddress the address where order is delivered
     * @param orderId the unique identifier for the order
     * @param orderTotal the total amount of order
     * @param status order status
     */
    public Order(float orderTotal, String deliveryAddress, float taxPercentage, int orderId, orderstatus status) {
        this.orderTotal = orderTotal;
        this.deliveryAddress = deliveryAddress;
        this.taxPercentage = taxPercentage;
        this.orderId = orderId;
        this.status = status;
    }

    /**
     * Default constructor
     */
    public Order() {
        this.orderTotal = 0.0f;
        this.deliveryAddress = "";
        this.taxPercentage = 0.0f;
        this.orderId = 0;
        this.status = orderstatus.NEW;
    }

    /** Get the order ID of this order
     * @return an integer representing the auto
     * generated order ID
     */
    public int getOrderID () {
        return orderId;
    }

    /** Get the order status of this order
     * @return an enumerated value OPEN or CLOSED
     * representing the order status.
     */
    public orderstatus getStatus () {
        return status;
    }
};
