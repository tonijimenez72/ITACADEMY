package scapeRoom.clue;

import scapeRoom.ivaType.IvaType;

public class Clue {
    private static final double VAT = 0.10;
    private final int id;
    private String name;
    private double price;
    private double estimatedTime;
    private String theme;
    private IvaType ivaType;

    public Clue(int id, String name, double price, double estimatedTime, String theme) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.estimatedTime = estimatedTime;
        this.theme = theme;
        this.ivaType = ivaType;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public double getEstimatedTime() {
        return estimatedTime;
    }
    public String getTheme() {
        return theme;
    }
    public IvaType getIvaType() {
        return ivaType;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setEstimatedTime(double estimatedTime) {
        this.estimatedTime = estimatedTime;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }
    public void setIvaType(IvaType ivaType) {
        this.ivaType = ivaType;
    }

    @Override
    public String toString() {
        return "Clue" +
                "\n ID: " + id +
                "\n Name: " + name +
                "\n Price: " + price +
                "\n Stimated Time: " + estimatedTime +
                "\n Theme: " + theme +
                "\n IVA Type: " + ivaType;
    }
}
