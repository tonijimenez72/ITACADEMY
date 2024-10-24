package n1exercise2;

public class GenericMethods {
    public static <T, U, V> String genericMethod(T generic1, U generic2, V generic3) {
        return generic1 + ", " + generic2 + ", " + generic3 + ".";
    }
}
