package n1exercise2;

class Online extends Worker {
    private static final double INTERNET_PLUS = 50.0;

    public Online(String name, String surname, double price) {
        super(name, surname, price);
    }

    @Override
    public double calculateSalary(int hours) {
        return (super.calculateSalary(hours) + INTERNET_PLUS);
    }

    @Deprecated
    public String deprecate() {
       return "Online workers will use 56 kbps modems anymore.";
    }
}
