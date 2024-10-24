package n2exercise1.observer;

public class StockMarketAgency {
    private String name;

    public StockMarketAgency(String name) {
        this.name = name;
    }

    public void update(double stockValue) {
        System.out.println("Agency " + name + ": Stock value changed to " + stockValue);
    }

    public String getName() {
        return name;
    }
}
