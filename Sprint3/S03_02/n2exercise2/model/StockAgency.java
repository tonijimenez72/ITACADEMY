package n2exercise2.model;


public abstract class StockAgency {
    protected String name;

    public StockAgency() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}