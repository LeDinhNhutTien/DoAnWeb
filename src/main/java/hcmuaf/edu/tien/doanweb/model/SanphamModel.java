package hcmuaf.edu.tien.doanweb.model;

import hcmuaf.edu.tien.doanweb.entities.Product;

import java.io.Serializable;
import java.util.List;

public class SanphamModel implements Serializable {
    public List<Product> products;
    // lấy ra sp ở trong giỏ
    public Product getProductbyId(int id) {
        for (Product p : products){
            if(p.getId() == id) return p;
        }
        return null;
    }
}
