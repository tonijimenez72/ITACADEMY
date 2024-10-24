package scapeRoom.ivaType;

public enum IvaType {
    IVAType21(0.21), IVAType10(0.10);

    private double percentage;

    IvaType(double percentage) {
        this.percentage = percentage;
    }

    public double getPercentage() {
        return percentage;
    }
}
