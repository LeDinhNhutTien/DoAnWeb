package hcmuaf.edu.tien.doanweb.entities;

import java.io.Serializable;

public class Item implements Serializable {
    private ProductEntity product;
    private int quantity;
    private double price;

    public Item() {
    }

    public Item(ProductEntity product, int quantity, double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
