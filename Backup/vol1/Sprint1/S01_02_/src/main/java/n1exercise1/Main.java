package n1exercise1;

public class Main {
    public static void main(String[] args) {
        Sale emptySale = new Sale();
        Sale sale = PopulateTest.populateTest();

        System.out.println(GetTotal.getTotal(emptySale) + "\n"
                + GetTotal.getTotal(sale));
    }
}
