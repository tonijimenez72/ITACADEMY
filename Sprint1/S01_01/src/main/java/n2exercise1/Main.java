package n2exercise1;

public class Main {
    public static void main(String[] args) {
        Smartphone one = new Smartphone("Moto", "g31");

        Telephone.call("+34555999222");
        one.photograph();
        one.alarm();
    }
}