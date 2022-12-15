package hcmuaf.edu.tien.doanweb.dao;

import hcmuaf.edu.tien.doanweb.entities.*;
import hcmuaf.edu.tien.doanweb.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private Connection conn = null;
    private PreparedStatement ps = null;
    protected ResultSet rs = null;

    // load all san pham
    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT id,name,price,image,description FROM products ";
        try {
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
            products.add(new Product(rs.getInt(1),
                    rs.getString(2), rs.getDouble(3),
                    rs.getString(4),rs.getString(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    // load san pham hot
    public List<Product> getProducHot() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT id,name,price,image,description FROM products  " +
                "where isHot =1 ORDER BY id DESC LIMIT 6";
        try {
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                products.add(new Product(rs.getInt(1),
                        rs.getString(2), rs.getDouble(3),
                        rs.getString(4),rs.getString(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    // load san pham ban chay
    public List<Product> getProducSell() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT id,name,price,image,description FROM products  " +
                "where isSell =1 ORDER BY id DESC LIMIT 6";
        try {
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                products.add(new Product(rs.getInt(1),
                        rs.getString(2), rs.getDouble(3),
                        rs.getString(4),rs.getString(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
    // load san pham khuyen mai
    public List<Product> getProducPromotion() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT id,name,price,image,description FROM products " +
                " where isPromotion =1 ORDER BY id DESC LIMIT 6";
        try {
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                products.add(new Product(rs.getInt(1),
                        rs.getString(2), rs.getDouble(3),
                        rs.getString(4),rs.getString(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
    // load slider

    // lấy ra sp có id
    public Product getProductByID(int id) {
        String sql = "SELECT id,name,price,image,description FROM products WHERE id = ?";
        try {
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2), rs.getDouble(3),
                        rs.getString(4),rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // lấy ra những ở sp từng danh muc
    public List<Product> getProductByCateID(String cid) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT id,name,price,image,description FROM products WHERE cateID = ?";
        try {
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,cid);
            rs = ps.executeQuery();

            while (rs.next()) {
                products.add(new Product(rs.getInt(1),
                        rs.getString(2), rs.getDouble(3),
                        rs.getString(4),rs.getString(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    // tim kiem sp
    public List<Product> searchByName(String txtSearch) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT id,name,price,image,description FROM products WHERE name like ?";
        try {
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,"%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                products.add(new Product(rs.getInt(1),
                        rs.getString(2), rs.getDouble(3),
                        rs.getString(4),rs.getString(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    // load danh muc
    public List<Categary> getAllCategary() {
        List<Categary> products = new ArrayList<>();
        String sql = "SELECT cid,cname,image FROM category ";
        try {
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                products.add(new Categary(rs.getInt(1),
                        rs.getString(2), rs.getString(3)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    // Đăng nhập
    public User login(String user, String pass){
        String query = "select id,user,pass,fullname,role from user \n" + "where user = ?\n" + "and pass = ?";
        try {
            conn = ConnectionUtil.getConnection(); // mo ket noi voi mysql
            ps = conn.prepareStatement(query);
            ps.setString(1,user);
            ps.setString(2,pass);
            rs = ps.executeQuery();
            if (rs.next()){
                return  new User(rs.getInt(1),rs.getString(2),
             rs.getString(3),rs.getString(4),rs.getInt(5));
            }
        }
        catch (Exception e){
        }
        return null;
    }

    // kiểm tra tài khoản đã tồn tại hay chưa
    public User checkAccountExits(String user){
        String query = "select id,user,pass,fullname,role from user \n" + "where user = ?\n" + "and pass = ?";
        try {
            conn = ConnectionUtil.getConnection(); // mo ket noi voi mysql
            ps = conn.prepareStatement(query);
            ps.setString(1,user);
            rs = ps.executeQuery();
            while (rs.next()){
                return  new User(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),rs.getInt(5));
            }
        }
        catch (Exception e){
        }
        return null;
    }

    // đăng ký tk
    public  void sign_up(String user, String pass){
        String query = "insert into user(`user`,pass,role)"+ " values(?,?,0)";
        try {
            conn = ConnectionUtil.getConnection(); // mo ket noi voi mysql
            ps = conn.prepareStatement(query);
            ps.setString(1,user);
            ps.setString(2,pass);
            ps.executeUpdate();
        }catch (Exception e){
        }
    }

    // khach hang dang nhap
    public Customer getAcount(String user, String pass){
        String query = "select * from customer \n" + "where user = ?\n" + "and pass = ?";
        try {
            conn = ConnectionUtil.getConnection(); // mo ket noi voi mysql
            ps = conn.prepareStatement(query);
            ps.setString(1,user);
            ps.setString(2,pass);
            rs = ps.executeQuery();
            if (rs.next()){
                return  new Customer(rs.getInt(1),rs.getString(2),
                        rs.getDouble(3),rs.getString(4),rs.getString(5));
            }
        }
        catch (Exception e){
        }
        return null;
    }

    // them vao don hang
    public void addOrder(Customer customer,Cart cart){
        LocalDate curDate = java.time.LocalDate.now();
        String date = curDate.toString();
        try{
            // add vao bang order
            String sql = "insert into Order values(?,?,?)";
            conn = ConnectionUtil.getConnection(); // mo ket noi voi mysql
            ps = conn.prepareStatement(sql);
            ps.setString(1,date);
            ps.setInt(2,customer.getId());
            ps.setDouble(3,cart.getTotalMoney());
            ps.executeUpdate();
            // lay ra id cua Order vua add
            String sql1 = "select top 1 id from Order order by id desc";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            rs = ps1.executeQuery();
            // add vao bang OrderDetail
            if(rs.next()){
                int oid = rs.getInt(1);
                for(Item i: cart.getItems()){
                    String sql2 = "insert into OrderDetail values(?,?,?,?)";
                    PreparedStatement ps2 = conn.prepareStatement(sql2);
                    ps2.setInt(1,oid);
                    ps2.setInt(2,i.getProduct().getId());
                    ps2.setInt(3,i.getQuantity());
                    ps2.setDouble(4,i.getPrice());
                    ps2.executeUpdate();
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    // đếm số lượng sp trong db
    public  int getToltalProducts(){
        String sql = "SELECT COUNT(*) FROM `products`";
        try {
            conn = ConnectionUtil.getConnection(); // mo ket noi voi mysql
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
               return rs.getInt(1);
            }
        }catch (Exception e){
        }
        return 0;
    }

    // hàm trả về 9 sp, mỗi lần nhấn qua trang tiếp theo
    public  List<Product> pagingProduct(int index){
        List<Product> list = new ArrayList<>();
        String sql = "SELECT id,name,price,image,description FROM `products` ORDER BY id LIMIT ?,9";
        try {
            conn = ConnectionUtil.getConnection(); // mo ket noi voi mysql
            ps = conn.prepareStatement(sql);
            ps.setInt(1,(index-1)*9);
            rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Product(rs.getInt(1),
                        rs.getString(2), rs.getDouble(3),
                        rs.getString(4),rs.getString(5)));
            }
        }catch (Exception e){
        }
        return list;
    }

    public static void main(String[] args) {
        DAO productDAO = new DAO();
        List<Product> products = productDAO.getProducHot();
        for (Product product : products) {
            System.out.println(product);
        }

    }
}

