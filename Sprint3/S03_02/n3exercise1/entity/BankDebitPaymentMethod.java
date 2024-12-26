package n3exercise1.entity;

import n3exercise1.service.PaymentCallback;

public class BankDebitPaymentMethod implements PaymentMethod {
    @Override
    public void makePayment(double amount, PaymentCallback callback) {
        callback.onPaymentSuccess(amount);
    }
}
