package n1exercise1;

import n1exercise1.sale.Sale;
import n1exercise1.sampleData.SampleData;


public class Main {
    public static void main(String[] args) {
        Sale emptySale = new Sale();
        Sale sale = SampleData.run();

        Sale.getTotal(emptySale);

        Sale.getTotal(sale);

        sale.checkIndexOutOfBounds(10);
    }
}