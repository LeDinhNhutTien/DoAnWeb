package hcmuaf.edu.tien.doanweb.entities;

public class ListOder {
    private  int id;
    private  String name;
    private  String date;
    private  int quantity;
    private  int totalMoney;

    public ListOder(int id, String name, String date, int quantity, int totalMoney) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.quantity = quantity;
        this.totalMoney = totalMoney;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "ListOder{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", quantity=" + quantity +
                ", totalMoney=" + totalMoney +
                '}';
    }
}
