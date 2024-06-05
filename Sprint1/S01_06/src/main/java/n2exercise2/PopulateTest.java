package n2exercise2;

public class PopulateTest {
    public static String testVarArgs() {
        Person person = new Person("Joana", "Petita", 30);

        String result1 = VarArgs.varArgsMethod("Person info", person, " but she looks like ", "29.5 years old");
        String result2 = VarArgs.varArgsMethod("Boolean values", true, '&', false);
        String result3 = VarArgs.varArgsMethod("Commands", "Ready", "Steady", "Go");

        return result1 + "\n" + result2 + "\n" + result3;
    }
}
