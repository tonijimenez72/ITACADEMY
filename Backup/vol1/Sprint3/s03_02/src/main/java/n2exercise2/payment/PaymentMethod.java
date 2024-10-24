package n2exercise2.payment;

public interface PaymentMethod {
    void makePayment(double amount, PaymentCallback callback);
}
