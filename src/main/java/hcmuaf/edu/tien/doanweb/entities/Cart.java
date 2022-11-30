package hcmuaf.edu.tien.doanweb.entities;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items;

    public Cart(List<Item> items) {
        this.items = items;
    }
    public Cart() {
        items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
    // trả về số lượng sp khi biết id
    public int getQuantityById(int id){
        return getItembyId(id).getQuantity();
    }
    // lấy ra sp ở trong giỏ
    private  Item getItembyId(int id) {

        for (Item i : items)
            if(i.getProduct().getId() == id) return i;
        return null;
    }
    // thêm sp
    public void addItem(Item i){
        // có ở trong giỏ rồi
        if(getItembyId(i.getProduct().getId()) != null){
            Item m = getItembyId(i.getProduct().getId());
            m.setQuantity(m.getQuantity()+ i.getQuantity());
        }else // chưa có
            items.add(i);
    }
    public void removeItem(int id){
        if(getItembyId(id) != null) items.remove(getItembyId(id));
    }
    public double getTotalMoney(){
        double t =0;
        for(Item i: items) t+= (i.getQuantity()*i.getProduct().getPrice());
        return t;
    }
}
