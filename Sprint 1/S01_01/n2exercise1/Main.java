package n2exercise1;

import n2exercise1.devices.*;

public class Main {
    public static void main(String[] args) {
        Smartphone one = new Smartphone("Moto", "g31");

        Telephone.call("+34555999222");
        one.photo();
        one.alarm();
    }
}