package n1exercise1;

import n1exercise1.exception.EmptySaleException;
import n1exercise1.sale.Sale;
import n1exercise1.sampleData.SampleData;


public class Main {
    public static void main(String[] args) {
        Sale emptySale = new Sale();
        Sale sale = SampleData.run();

        getTotal(emptySale);

        getTotal(sale);

        printProductByIndex(sale,2);

        printProductByIndex(sale, 10);
    }

    private static void getTotal(Sale sale) {
        try {
            sale.calculateTotal();
            System.out.println("Total price: " + sale.getTotalPrice() + " €");
        } catch (EmptySaleException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void printProductByIndex(Sale sale, int index){
        try {
            System.out.println(sale.getProductAt(index).getName() + ": " + sale.getProductAt(index).getPrice() + " €");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Index out of bounds. " + e.getMessage());
        }
    }
}