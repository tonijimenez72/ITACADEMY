package n2exercise1;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Smartphone one = new Smartphone("Moto", "g31");

        Telephone.call("+34555999222");
        one.photograph();
        one.alarm();
    }
}