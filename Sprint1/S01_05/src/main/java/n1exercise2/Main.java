package n1exercise2;

public class Main {
    public static void main(String[] args) {
        String path = "";
        path = GetPath.checkParameter(args);

        System.out.println(GetPath.getChildItemsRecursive(path));
    }
}
