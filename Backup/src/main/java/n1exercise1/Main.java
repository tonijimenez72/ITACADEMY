package n1exercise1;

public class Main {
    public static void main(String[] args) {
        String path = "";
        path = GetPath.checkParameter(args);

        System.out.println(GetPath.getChildItems(path));
    }
}
