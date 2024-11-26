package n1exercise2;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Joana", "Petita", 40);

        System.out.println("Example 1:");
        GenericMethods.genericMethod(person, "but she looks like", 39.5);

        System.out.println("\nExample 2:");
        GenericMethods.genericMethod(true, '&', false);

        System.out.println("\nExample 3:");
        GenericMethods.genericMethod("Ready", "Steady", "Go");

        System.out.println("\nExample 4:");
        GenericMethods.genericMethod("Unsorted: She looks like", 39.5, person);
    }
}