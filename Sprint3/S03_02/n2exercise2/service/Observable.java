package n2exercise2.service;

public interface Observable {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyChanges(int movement);
}
