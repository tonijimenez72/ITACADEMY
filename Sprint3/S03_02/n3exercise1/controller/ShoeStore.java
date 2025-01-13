package n3exercise1.controller;

import n3exercise1.entity.BankDebitPaymentMethod;
import n3exercise1.entity.CreditCardPaymentMethod;
import n3exercise1.entity.PaymentMethod;
import n3exercise1.entity.PaypalPaymentMethod;
import n3exercise1.service.PaymentCallback;
import n3exercise1.service.PaymentGateway;

public class ShoeStore {
    public void run() {
        PaymentGateway paymentGateway = new PaymentGateway();
        PaymentMethod creditCard = new CreditCardPaymentMethod();

        paymentGateway.processPayment(creditCard, 100.0, new PaymentCallback() {
            @Override
            public void onPaymentSuccess(double amount) {
                System.out.println("Successful payment with credit card: " + amount + " euros.");
            }
        });

        PaymentMethod paypal = new PaypalPaymentMethod();
        paymentGateway.processPayment(paypal, 50.0, new PaymentCallback() {
            @Override
            public void onPaymentSuccess(double amount) {
                System.out.println("Successful payment with Paypal: " + amount + " euros.");
            }
        });

        PaymentMethod bankDebit = new BankDebitPaymentMethod();
        paymentGateway.processPayment(bankDebit, 200.0, new PaymentCallback() {
            @Override
            public void onPaymentSuccess(double amount) {
                System.out.println("Successful payment with bank debit:  " + amount + " euros.");
            }
        });
    }
}
