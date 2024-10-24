package scapeRoom.decoration;

import scapeRoom.ivaType.IvaType;

public class Decoration {
    private static final double VAT = 0.21;
    private final int id;
    private String name;
    private double price;
    private String materialType;
    private int stock;
    private IvaType ivaType;

    public Decoration(int id, String name, double price, String materialType, int stock, IvaType ivaType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.materialType = materialType;
        this.stock = stock;
        this.ivaType = this.ivaType;
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
    public String getMaterialType() {
        return materialType;
    }
    public int getStock() {
        return stock;
    }
    public IvaType getIvaType() {
        return ivaType;
    }

    @Override
    public String toString() {
        return "Decorations" +
                "\n ID: " + id +
                "\n Name: " + name +
                "\n Price: " + price +
                "\n Material Type: " + materialType + '\'' +
                "\n Stock: " + stock +
                "\n IVA Type: " + ivaType;
    }
}