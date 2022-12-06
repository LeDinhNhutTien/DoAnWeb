package hcmuaf.edu.tien.doanweb.entities;
import hcmuaf.edu.tien.doanweb.model.SanphamModel;

import java.util.*;
public class Cart2 {
    HashMap<Integer,Item> cart;

    public Cart2() {
        cart = new HashMap<>();
    }

    // them sp vao gio hang
    public void addSanPham(int masp){
        // nếu mã sp có trong giỏ hàng thì ta tăng lên 1
        if(cart.containsKey(masp)){
            Item item = cart.get(masp);
            item.setQuantity(item.getQuantity()+1);
        }
        // nếu mã sp chưa có trong giỏ hàng thì ta thêm
        else {
            // dua vao masp lay ra sp
            Product product = new SanphamModel().getProductbyId(masp);
            Item item = new Item(product,1);
            // them vao gio hang
            cart.put(masp,item);
        }
    }
    // ham lay ra cac item cua gio hang
    public  ArrayList<Item> getListItems(){
        ArrayList<Item> list= new ArrayList<>();
        // cart.values() tap hop cac items trong gio hang
        for (Item i: cart.values()){
            list.add(i);
        }
        return list;
    }
}
