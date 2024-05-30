package n2exercice1;

public class Smartphone extends Telephone implements Camera, Clock {

    public Smartphone(String tradeMark, String model) {
        super(tradeMark, model);
    }

    @Override
    public void photograph() {
        System.out.println("S'està fent una foto.");
    }

    @Override
    public void alarm() {
        System.out.println("Està sonant l'alarma.");
    }
}