package n1exercice1;

public class Percussion extends Instrument{

    public Percussion(String name, double price) {
        super(name, price);
    }

    @Override
    public void play() {
        System.out.println("Està sonant un instrument de percussió. " + instrument());
    }
}
