package n1exercise1.initializer;

import n1exercise1.instruments.Percussion;
import n1exercise1.instruments.Strings;
import n1exercise1.instruments.Wind;

public class Initializer {
    public void initialize() {

        Wind flute = new Wind("flute", 50);
        flute.play();

        Strings violin = new Strings("violin", 100);
        violin.play();

        Percussion drum = new Percussion("drum", 80);
        drum.play();
    }
}