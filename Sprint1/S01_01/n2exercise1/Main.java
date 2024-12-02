package n2exercise1;

import n2exercise1.device.*;

public class Main {
    public static void main(String[] args) {
        Smartphone smartphoneOne = new Smartphone("Moto", "g31");

        smartphoneOne.call("+34555999222");
        smartphoneOne.photo();
        smartphoneOne.alarm();
    }
}