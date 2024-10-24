package n1exercise1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Months {
    private List<String> months;

    public Months() {
        months = new ArrayList<>(Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"));
    }

    public List<String> getMonths() {
        return months;
    }
}