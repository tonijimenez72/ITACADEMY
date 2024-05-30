package n3exercice1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IOMenuMethods ioMenuMethods = new IOMenuMethods();

        //Hi, tester, this is going to do your life
        // a little bit easier. Have a nice day!
        PopulateTest.populate();

        ioMenuMethods.Switch(scanner);
        scanner.close();
    }
}

