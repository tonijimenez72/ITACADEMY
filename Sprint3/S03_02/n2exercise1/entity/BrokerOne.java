package n2exercise1.entity;

import n2exercise1.service.Observer;

public class BrokerOne extends StockAgency implements Observer {
    public BrokerOne() {
        this.name="Broker One";
    }

    @Override
    public void update(String message) {
        System.out.println(getName() + " has received the following message: '" + message + ".");
    }
}