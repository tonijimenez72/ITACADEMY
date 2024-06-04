package n1exercise1;

import java.util.*;

public class Month {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {


        ArrayList<String>months = new ArrayList<>();
        
        months.add("January");
        months.add("February");
        months.add("March");
        months.add("April");
        months.add("May");
        months.add("June");
        months.add("July");
        months.add("September");
        months.add("October");
        months.add("November");
        months.add("December");

        months.add(7, "August");

        System.out.printf(ANSI_GREEN + "Printing months ArrayList: \n" + ANSI_RESET);
        for(String month : months){
            System.out.printf( month + " ");
        }

        Set<String> monthsHashset = new HashSet<>(months);

        months.add("August");
        months.add("Luigi");

        monthsHashset.add("August");
        monthsHashset.add("Luigi");

        System.out.printf(ANSI_RED + "\nPrinting months Hashset with 'for': \n" + ANSI_RESET);
        for(String month : monthsHashset){
            System.out.printf(month + " ");
        }

        Set<String> monthsLinkedHashSet = new LinkedHashSet<>(months);

        System.out.printf(ANSI_GREEN + "\nPrinting months LinkedHashSet with 'for': \n" + ANSI_RESET);
        for(String month : monthsLinkedHashSet){
            System.out.printf(month + " ");
        }

        System.out.printf(ANSI_GREEN + "\nPrinting months LinkedHashSet with 'Iterator': \n" + ANSI_RESET);
        Iterator<String> month = monthsLinkedHashSet.iterator();
        while(month.hasNext()){
            System.out.println(month.next());
        }


    }
}
