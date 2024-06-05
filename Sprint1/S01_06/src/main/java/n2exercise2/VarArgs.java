package n2exercise2;

public class VarArgs {
    @SafeVarargs
    public static <T> String varArgsMethod(String fixedParam, T... generics) {
        String result = fixedParam + ": ";
        for (T generic : generics) {
            result += generic + ", ";
        }
        // Remove the last comma and space
        if (result.length() > 0) {
            result = result.substring(0, result.length() - 2);
        }
        result += ".";
        return result;
    }
}