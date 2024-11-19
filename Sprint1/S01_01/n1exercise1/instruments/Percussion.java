package n1exercise1.instruments;

public class Percussion extends Instrument {

    public Percussion(String name, double price) {
        super(name, price);
    }

    @Override
    public void play() {
        System.out.println("Percussion instrument sounds.");
    }
}