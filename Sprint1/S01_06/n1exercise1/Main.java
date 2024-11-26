package n1exercise1;

public class Main {
    public static void main(String[] args) {
        NoGenericMethods instance1 = new NoGenericMethods("Go", "Ready", "Steady");
        NoGenericMethods instance2 = new NoGenericMethods("Ready", "Steady", "Go");
        NoGenericMethods instance3 = new NoGenericMethods("Steady", "Go", "Ready");

        System.out.println("Instance 1: \n" + instance1 + "\n"
                + "Instance 2: \n" + instance2 + "\n"
                + "Instance 3: \n" + instance3);
    }
}