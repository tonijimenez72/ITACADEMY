package n2exercise1;

import static n2exercise1.Entrada.*;

public class Main {
    public static void main(String[] args) {
        byte bInput = 0;
        int iInput = 0;
        double dInput = 0D;
        float fInput = 0F;
        char cInput;
        String sInput = "";
        boolean booInput = false;
        String message = "";

        message = "Quants anys tens?";


        bInput = readByte(message);
        System.out.println("Et conserves molt bé per tenir " + bInput + " anys!" );

        iInput = readInt(message);
        System.out.println("Et conserves molt bé per tenir " + iInput + " anys!" );

        message = "Quantes de les antigues pessetes és un euro?";

        fInput = readFloat(message);
        System.out.println(fInput + ". Qui es recorda ja?" );

        dInput = readDouble(message);
        System.out.println(dInput + ". Vols dir?" );

        message = "Amb quina lletra comença el cognom del Pare del Java?";

        cInput = readChar(message);
        System.out.println("Has indicat una " + cInput + " i la veritat és que comença amb G de Gosling. El James Gosling!");

       message = "Digues el nom del famós actor amb el mateix cognom?";

       sInput = readString(message);
       System.out.println("Has dit " + sInput + " i resulta que és diu RYAN, Ryan Gosling.");

        message = "Creus que el James i el Ryan són familia? S/N";

        booInput = readBoolean(message);
        if (booInput){
            System.out.println("Has dit que sí (" + booInput + "). Què fort!");
        } else {
            System.out.println("Has dit que no (" + booInput + "). I want to believe!");
        }
    }

    void closeScanner() {
        closeScanner();
    }
}

