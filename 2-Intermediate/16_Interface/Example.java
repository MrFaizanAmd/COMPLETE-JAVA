interface Payment {
    void processPayment(double amount);
}

class CreditCardPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
    }
}

class PayPalPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

class BankTransferPayment implements Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing bank transfer payment of $" + amount);
    }
}

public class Example {
    public static void main(String[] args) {
        Payment payment1 = new CreditCardPayment();
        payment1.processPayment(100.50);
        
        Payment payment2 = new PayPalPayment();
        payment2.processPayment(75.25);
        
        Payment payment3 = new BankTransferPayment();
        payment3.processPayment(200.00);
    }
}
