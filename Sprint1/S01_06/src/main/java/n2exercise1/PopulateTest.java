package n2exercise1;

public class PopulateTest {
    public static String testGenericMethods() {
        Person person = new Person("Joana", "Petita", 30);

        String result1 = MixedMethods.genericMethod(person, " but she looks like ", "noGeneric");
        String result2 = MixedMethods.genericMethod(true, '&' , "noGeneric");
        String result3 = MixedMethods.genericMethod("Ready", "Steady", "noGeneric");

        return result1 + "\n" + result2 + "\n" + result3;
    }
}
