package n1exercise1.sampleData;

import n1exercise1.product.Product;
import n1exercise1.sale.Sale;

public class SampleData {
    public static Sale run() {
        Sale sale = new Sale();

        sale.addProduct(new Product("Product 1", 1.00));
        sale.addProduct(new Product("Product 2.", 2.00));
        sale.addProduct(new Product("Product 3", 3.00));

        return sale;
    }
}