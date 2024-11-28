package n2exercise1;

import n2exercise1.device.*;

public class Main {
    public static void main(String[] args) {
        Smartphone smartphoneOne = new Smartphone("Moto", "g31");

        System.out.println("Static method that is common to all the types of Telephone:");
        Telephone.call("+34555999222");

        System.out.println("Non static methods that can only be used with instances of the Smartphone class:");
        smartphoneOne.photo();
        smartphoneOne.alarm();
    }
}