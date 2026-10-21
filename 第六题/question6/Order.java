package question6;

import java.util.*;

public class Order implements Comparable<Order> {
    @Override
    public int compareTo(Order otherOrder) {
        int result = Double.compare(otherOrder.orderTotal, this.orderTotal);
        if (result != 0) {
            return result;
        }
        return this.orderNumber.compareTo(otherOrder.orderNumber);
    }

    private String orderNumber;
    private String customerName;
    private double orderTotal;
    private List<String> productTag;

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public List<String> getProductTag() {
        return productTag;
    }
    public Order(String orderNumber, String customerName, double orderTotal, List<String> productTag) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.orderTotal = orderTotal;
        this.productTag = productTag;
    }
    @Override
    public String toString() {
        return "Order{" + orderNumber + ", " + customerName + ", " + orderTotal + ", " + productTag + "}";
    }
}
