package n2exercise1;

abstract class Telephone {
    private String tradeMark;
    private String model;

    public Telephone(String tradeMark, String model) {
        this.tradeMark = tradeMark;
        this.model = model;
    }

    public static void call(String number) {
        System.out.println("S'està trucant al número " + number + ".");
    }
}
