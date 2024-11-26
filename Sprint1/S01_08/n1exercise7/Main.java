package n1exercise7;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> list = Arrays.asList(2, "all together", 2, "put it");

        System.out.println(GetList.getListByLength(list));
    }
}
