package n1exercise2;

public class PopulateTest {
    public static String testGenericMethods() {
        Person person = new Person("Joana", "Petita", 30);

        String result1 = GenericMethods.genericMethod(person, " but she looks like ", 29.5);
        String result2 = GenericMethods.genericMethod(true, '&' , false);
        String result3 = GenericMethods.genericMethod("Ready", "Steady", "Go");
        String result4 = GenericMethods.genericMethod("Unsorted: She looks like ", 29.5, person);

        return result1 + "\n" + result2 + "\n" + result3 +  "\n" + result4;
    }
}