// SealedExample4.java - Sealed Class with Abstract Methods
sealed abstract class Payment permits CreditCard, PayPal {}

final class CreditCard extends Payment {
    void process() {
        System.out.println("Processing Credit Card Payment");
    }
}

final class PayPal extends Payment {
    void process() {
        System.out.println("Processing PayPal Payment");
    }
}

public class SealedExample4 {
    public static void main(String[] args) {
        Payment cc = new CreditCard();
        Payment pp = new PayPal();
        ((CreditCard) cc).process();
        ((PayPal) pp).process();
    }
}