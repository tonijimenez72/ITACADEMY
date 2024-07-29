package n2exercise2.payment;

public interface PaymentCallback {
    void onPaymentSuccess(double amount);
    // void onPaymentFailure(String errorMessage);
}