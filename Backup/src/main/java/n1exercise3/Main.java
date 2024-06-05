package n1exercise3;

public class Main {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        String path = GetPath.checkParameter(args);

        System.out.println(GetPath.writeToFile(GetPath.getChildItemsRecursive(path)));
    }
}

