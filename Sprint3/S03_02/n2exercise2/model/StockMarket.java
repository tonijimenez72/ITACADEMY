package n2exercise2.model;

public class StockMarket {
    private String name;
    private int index = 100;

    public StockMarket(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void movement (int value) {
        setIndex(index+value);
    }
}
