package n1exercise5;

import n1exercise5.interfaces.PiValueFI;

public class Main {
    public static void main(String[] args) {
        PiValueFI pi = () -> 3.1415;

        System.out.println("π = " + pi.getPiValue());
    }
}

