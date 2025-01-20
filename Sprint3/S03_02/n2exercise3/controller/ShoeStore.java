package n2exercise3.controller;

import n2exercise3.model.BankDebitPaymentMethod;
import n2exercise3.model.CreditCardPaymentMethod;
import n2exercise3.model.PaymentMethod;
import n2exercise3.model.PaypalPaymentMethod;
import n2exercise3.service.PaymentCallback;
import n2exercise3.service.PaymentGateway;

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
