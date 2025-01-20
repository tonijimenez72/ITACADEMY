package n2exercise2;

import n2exercise2.model.Broker;
import n2exercise2.model.BrokerOne;
import n2exercise2.model.BrokerTwo;

public class Main {
    public static void main(String[] args) {
        Broker broker = new Broker();

        BrokerOne brokerOne = new BrokerOne();
        BrokerTwo brokerTwo = new BrokerTwo();

        broker.subscribe(brokerOne);
        broker.subscribe(brokerTwo);

        broker.notifyChanges(+100);

        broker.unsubscribe(brokerTwo);

        broker.notifyChanges(-10);
    }
}