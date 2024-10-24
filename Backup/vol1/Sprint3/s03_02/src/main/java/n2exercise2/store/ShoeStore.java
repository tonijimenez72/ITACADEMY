package n2exercise2.store;

import n2exercise2.payment.*;

public class ShoeStore {
    public void start() {
        PaymentGateway paymentGateway = new PaymentGateway();

        PaymentMethod creditCard = new CreditCard();
        paymentGateway.processPayment(creditCard, 100.0, new PaymentCallback() {
            @Override
            public void onPaymentSuccess(double amount) {
                System.out.println("Successful payment with credit card: " + amount + " euros.");
            }
        });

        PaymentMethod paypal = new Paypal();
        paymentGateway.processPayment(paypal, 50.0, new PaymentCallback() {
            @Override
            public void onPaymentSuccess(double amount) {
                System.out.println("Successful payment with Paypal:" + amount + " euros.");
            }
        });

        PaymentMethod bankDebit = new BankDebit();
        paymentGateway.processPayment(bankDebit, 200.0, new PaymentCallback() {
            @Override
            public void onPaymentSuccess(double amount) {
                System.out.println("Successful payment with  " + amount + " euros.");
            }
        });
    }
}
