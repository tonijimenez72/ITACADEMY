package n2exercise1.input;

public class InputHandler {
    public static void handleQuery() {

        byte bInput = InputHelper.readByte("Input a byte:");
        System.out.println("You entered a byte: " + bInput);

        int iInput = InputHelper.readInt("Input an integer:");
        System.out.println("You entered an integer: " + iInput);

        float fInput = InputHelper.readFloat("Input a float:");
        System.out.println("You entered a float: " + fInput);

        double dInput = InputHelper.readDouble("Input a double:");
        System.out.println("You entered a double: " + dInput);

        char cInput = InputHelper.readChar("Input a character:");
        System.out.println("You entered a character: " + cInput);

        String sInput = InputHelper.readString("Input a string:");
        System.out.println("You entered a string: " + sInput);

        boolean booInput = InputHelper.readBoolean("Input 'Y' for yes or 'N' for no:");
        System.out.println("You answered: " + (booInput ? "yes" : "no"));
    }
}
