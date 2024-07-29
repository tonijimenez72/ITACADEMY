package n2exercise2.payment;

public class CreditCard implements PaymentMethod {
    @Override
    public void makePayment(double amount, PaymentCallback callback) {
        callback.onPaymentSuccess(amount);
    }
}