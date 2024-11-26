package n1exercise2;

public class GenericMethods {
    public static <T, U, V> void genericMethod(T param1, U param2, V param3) {
        System.out.println(param1 + ", " + param2 + ", " + param3 + ".");
    }
}
