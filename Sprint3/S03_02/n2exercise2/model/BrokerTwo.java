package n2exercise2.model;

import n2exercise2.service.Observer;

public class BrokerTwo extends StockAgency implements Observer {
    public BrokerTwo() {
        this.name = "Broker Two";
    }

    @Override
    public void update(String message) {
        System.out.println(getName() + " has received the following message: '" + message + ".");
    }
}