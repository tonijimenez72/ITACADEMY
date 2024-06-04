package n1exercise1;

public class PopulateTest {
    public static Sale populateTest() {
        Sale sale = new Sale();

        sale.addProduct(new Product("BBQ REYES PORK CRACKLINGS 1 kg.", 17.60));
        sale.addProduct(new Product("GRAFENWALDER PILS - pack 6.", 2.10));
        sale.addProduct(new Product("Red wine 2 l.", 2.60));
        sale.addProduct(new Product("HOLA COLA Zero 2 l.", 0.89));

        return sale;
    }
}

