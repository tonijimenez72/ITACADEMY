package n2exercise1;

public class MixedMethods {
    public static <T, U> String genericMethod(T generic1, U generic2, String nonGeneric) {
        return generic1 + ", " + generic2 + ", " + nonGeneric + ".";
    }
}