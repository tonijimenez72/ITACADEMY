package n2exercise3.model;

import n2exercise3.service.PaymentCallback;

public class PaypalPaymentMethod implements PaymentMethod {
    @Override
    public void makePayment(double amount, PaymentCallback callback) {
        callback.onPaymentSuccess(amount);
    }
}
