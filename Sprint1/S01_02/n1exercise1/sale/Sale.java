package n1exercise1.sale;

import n1exercise1.exception.EmptySaleException;
import n1exercise1.product.Product;

import java.util.ArrayList;

public class Sale {
    private ArrayList<Product> products;
    private double totalPrice;

    public Sale() {
        this.products = new ArrayList<>();
        this.totalPrice = 0;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public Product getProductAt(int index) {
        return this.products.get(index);
    }

    public void calculateTotal() throws EmptySaleException {
        if (products.isEmpty()) {
            throw new EmptySaleException();
        }
        totalPrice = 0.0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
    }

}