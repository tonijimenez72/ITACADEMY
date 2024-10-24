package n2exercise1.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StockMarketAgent {
    private List<StockMarketAgency> agencies = new ArrayList<>();
    private double stockValue = 1000.0d;
    private Random random = new Random();

    public void addObserver(StockMarketAgency agency) {
        agencies.add(agency);
    }

    public void removeObserver(StockMarketAgency agency) {
        agencies.remove(agency);
    }

    public void setStockValue(double stockValue) {
        this.stockValue = Math.round(stockValue * 1000.0) / 1000.0;
        notifyObservers();
    }

    private void notifyObservers() {
        for (StockMarketAgency agency : agencies) {
            agency.update(stockValue);
        }
    }

    public void notifyValueUp() {
        double randomValue = 0.001 + (0.999 - 0.001) * random.nextDouble();
        randomValue = Math.round(randomValue * 1000.0) / 1000.0;
        setStockValue(stockValue + randomValue);
    }

    public void notifyValueDown() {
        double randomValue = 0.001 + (0.999 - 0.001) * random.nextDouble();
        randomValue = Math.round(randomValue * 1000.0) / 1000.0;
        setStockValue(stockValue - randomValue);
    }

    public List<StockMarketAgency> getAgencies() {
        return agencies;
    }
}