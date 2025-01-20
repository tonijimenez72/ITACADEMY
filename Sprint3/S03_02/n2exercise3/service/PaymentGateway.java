package n2exercise3.service;

import n2exercise3.model.PaymentMethod;

public class PaymentGateway {
    public void processPayment(PaymentMethod paymentMethod, double amount, PaymentCallback callback) {
        paymentMethod.makePayment(amount, callback);
    }
}
