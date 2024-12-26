package n3exercise1.entity;

import n3exercise1.service.PaymentCallback;

public interface PaymentMethod {
    void makePayment(double amount, PaymentCallback callback);
}
