package n2exercise2.payment;

public class PaymentGateway {

    public void processPayment(PaymentMethod paymentMethod, double amount, PaymentCallback callback) {
        paymentMethod.makePayment(amount, callback);
    }
}
