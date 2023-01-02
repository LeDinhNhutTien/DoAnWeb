package hcmuaf.edu.tien.doanweb.entities;

import java.io.Serializable;

public class Item implements Serializable {
    private Product product;
    private int quantity;
    private int price;

    public Item() {
    }

    public Item(Product product, int quantity, int price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
