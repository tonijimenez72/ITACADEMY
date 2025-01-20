package n2exercise3.model;

import n2exercise3.service.PaymentCallback;

public interface PaymentMethod {
    void makePayment(double amount, PaymentCallback callback);
}
