package n2exercise1.entity;

import n2exercise1.service.Observable;
import n2exercise1.service.Observer;

import java.util.ArrayList;
import java.util.List;

public class Broker implements Observable {
    List<Observer> observers = new ArrayList<>();
    StockMarket market = new StockMarket("Market");

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyChanges(int movement) {
        market.movement(movement);
        for (Observer observer : observers) {
            observer.update("The index of " + market.getName() + ", has a movement of: " + movement);
        }
    }
}
