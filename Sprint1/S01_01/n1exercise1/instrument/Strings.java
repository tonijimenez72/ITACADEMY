package n1exercise1.instrument;

public class Strings extends Instrument {

    public Strings(String name, double price) {
        super(name, price);
    }

    @Override
    public void play() {
        System.out.println("A string instrument sounds.");
    }
}