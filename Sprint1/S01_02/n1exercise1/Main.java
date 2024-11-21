package n1exercise1;

import n1exercise1.sale.Sale;
import n1exercise1.sampleData.SampleData;


public class Main {
    public static void main(String[] args) {
        Sale emptySale = new Sale();
        Sale sale = SampleData.run();

        Sale.getTotal(emptySale);

        Sale.getTotal(sale);

        System.out.println("\nOK printing product with index contained in the Arraylist products:");
        try {
            System.out.println(sale.getProductAt(2).getName() + ": " + sale.getProductAt(2).getPrice());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Index out of bounds. " + e.getMessage());
        }

        System.out.println("\nError printing product with index outside the  in the Arraylist products:");
        try {
            System.out.println(sale.getProductAt(10).getName() + ": " + sale.getProductAt(10).getPrice());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Index out of bounds. " + e.getMessage());
        }
    }
}