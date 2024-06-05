package n2exercise3;

public class Calculator {
    // Define operations
    static CalcFI addition = (a, b) -> a + b;
    static CalcFI subtraction = (a, b) -> a - b;
    static CalcFI multiplication = (a, b) -> a * b;
    static CalcFI division = (a, b) -> a / b;

    public static String printResults(float a, float b) {
        String result = "";
        result = "Addition: " + calculateOperation(addition, a, b) + "\n"
                + "Subtraction: " + calculateOperation(subtraction, a, b) + "\n"
                + "Multiplication: " + calculateOperation(multiplication, a, b) + "\n"
                + "Division: " + calculateOperation(division, a, b);
        return result;
    }

    // Method to perform operations
    public static float calculateOperation(CalcFI operation, float a, float b) {
        return operation.calc(a, b);
    }
}