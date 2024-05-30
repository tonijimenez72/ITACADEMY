package n1exercice1;

public class Wind extends Instrument{

    public Wind(String name, double price) {
        super(name, price);
    }

    @Override
    public void play() {
        System.out.println("Està sonant un instrument de vent. " + instrument());
    }
}
