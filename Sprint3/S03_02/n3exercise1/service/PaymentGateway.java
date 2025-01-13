package n3exercise1.service;

import n3exercise1.entity.PaymentMethod;

public class PaymentGateway {
    public void processPayment(PaymentMethod paymentMethod, double amount, PaymentCallback callback) {
        paymentMethod.makePayment(amount, callback);
    }
}
