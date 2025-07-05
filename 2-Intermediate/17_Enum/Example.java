// Enum representing different order statuses
enum OrderStatus {
    PENDING,
    SHIPPED,
    DELIVERED,
    CANCELLED;
}

// Enum with fields, constructor, and methods
enum PaymentMethod {
    CREDIT_CARD("Credit Card"),
    PAYPAL("PayPal"),
    BITCOIN("Bitcoin");

    private String displayName;

    PaymentMethod(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

// Using Enums in a real-world example
class Order {
    private int orderId;
    private OrderStatus status;
    private PaymentMethod paymentMethod;

    public Order(int orderId, OrderStatus status, PaymentMethod paymentMethod) {
        this.orderId = orderId;
        this.status = status;
        this.paymentMethod = paymentMethod;
    }

    public void updateStatus(OrderStatus newStatus) {
        this.status = newStatus;
        System.out.println("Order " + orderId + " status updated to: " + newStatus);
    }

    public void printOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Status: " + status);
        System.out.println("Payment Method: " + paymentMethod.getDisplayName());
    }
}

public class Example {
    public static void main(String[] args) {
        // Creating an order
        Order order1 = new Order(101, OrderStatus.PENDING, PaymentMethod.CREDIT_CARD);
        order1.printOrderDetails();

        // Updating order status
        order1.updateStatus(OrderStatus.SHIPPED);
        order1.updateStatus(OrderStatus.DELIVERED);

        // Using Enum methods
        System.out.println("Available Payment Methods:");
        for (PaymentMethod method : PaymentMethod.values()) {
            System.out.println(method.getDisplayName());
        }
    }
}
