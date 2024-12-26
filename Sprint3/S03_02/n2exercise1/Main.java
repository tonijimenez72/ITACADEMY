package n2exercise1;

import n2exercise1.entity.Broker;
import n2exercise1.entity.BrokerOne;
import n2exercise1.entity.BrokerTwo;

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