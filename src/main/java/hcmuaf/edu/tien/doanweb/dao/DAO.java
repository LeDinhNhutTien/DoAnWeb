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
                    rs.getString(2), rs.getInt(3),
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
                        rs.getString(2), rs.getInt(3),
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
                        rs.getString(2), rs.getInt(3),
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
                        rs.getString(2), rs.getInt(3),
                        rs.getString(4),rs.getString(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    // load slider
        public List<Slider> getImageSlider(){
            List<Slider> list = new ArrayList<>();
            String sql = "SELECT id, image FROM `slider`";
            try {
                conn = ConnectionUtil.getConnection();
                ps = conn.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()){
                    list.add(new Slider(rs.getInt(1), rs.getString(2)));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return list;
        }
    // l???y ra sp c?? id
    public Product getProductByID(int id) {
        String sql = "SELECT id,name,price,image,description FROM products WHERE id = ?";
        try {
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2), rs.getInt(3),
                        rs.getString(4),rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // l???y ra nh???ng ??? sp t???ng danh muc
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
                        rs.getString(2), rs.getInt(3),
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
                        rs.getString(2), rs.getInt(3),
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

    // ????ng nh???p
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

    // ki???m tra t??i kho???n ???? t???n t???i hay ch??a
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

    // ????ng k?? tk
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

    // them vao don hang
    public void addOrder(User customer,Cart cart){
        LocalDate curDate = java.time.LocalDate.now();
        String date = curDate.toString();
        try{
            // add vao bang order
            String sql = "insert into orders(dateOrder,userId,totalmoney) values(?,?,?)";
            conn = ConnectionUtil.getConnection(); // mo ket noi voi mysql
            ps = conn.prepareStatement(sql);
            ps.setString(1,date);
            ps.setInt(2,customer.getId());
            ps.setInt(3,cart.getTotalMoney());
            ps.executeUpdate();
            // lay ra id cua Order vua add
            String sql1 = "select orderId from orders  order by orderId desc LIMIT 1";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            rs = ps1.executeQuery();
            // add vao bang OrderDetail
            if(rs.next()) {
                int oid = rs.getInt("orderId");
                for (Item i : cart.getItems()) {
                    String sql2 = "insert into orderdetail(oid,pid,quantity,price,pname) values(?,?,?,?,?)";
                    PreparedStatement ps2 = conn.prepareStatement(sql2);
                    ps2.setInt(1, oid);
                    ps2.setInt(2, i.getProduct().getId());
                    ps2.setInt(3, i.getQuantity());
                    ps2.setInt(4, i.getPrice());
                    ps2.setString(5,i.getProduct().getName());
                    ps2.executeUpdate();
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    // lay ra all cac don hang
    public List<ListOder> getAllOrder(){
        List<ListOder> list = new ArrayList<>();
        String sql = "SELECT DISTINCT o.orderId,od.pname, u.fullname, o.dateOrder, SUM(od.quantity) AS SoLuong, o.totalmoney\n" +
                "FROM orders o, orderdetail od, `user` u\n" +
                "WHERE od.oid = o.orderId and u.id = o.userId\n" +
                "GROUP BY o.orderId,od.pname, u.fullname, o.dateOrder, o.totalmoney";
        try {
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new ListOder(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getInt(5),rs.getInt(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // ?????m s??? l?????ng sp trong db
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

    // h??m tr??? v??? 9 sp, m???i l???n nh???n qua trang ti???p theo
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
                        rs.getString(2), rs.getInt(3),
                        rs.getString(4),rs.getString(5)));
            }
        }catch (Exception e){
        }
        return list;
    }

    // lay danh sach khach hang
    public  List<User> getAllCustomer(){
        List<User> list = new ArrayList<>();
        String sql = "SELECT o.userId,o.orderId,u.fullname,u.address FROM orders o, `user`u\n" +
                "WHERE o.userId = u.id\n" +
                "GROUP BY o.userId,o.orderId,u.fullname,u.address";
        try {
            conn = ConnectionUtil.getConnection(); // mo ket noi voi mysql
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                list.add(new User(rs.getInt(1),rs.getInt(2),rs.getString(3),
                        rs.getString(4)));
            }
        }catch (Exception e){
        }
        return list;
    }

    // lay danh sach nguoi dung (user)
    public  List<User> getAllUser(){
        List<User> list = new ArrayList<>();
        String sql = "SELECT id,user,pass,fullname,address,role FROM `user`\n";
        try {
            conn = ConnectionUtil.getConnection(); // mo ket noi voi mysql
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                list.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3)
                        ,rs.getString(4), rs.getString(5),rs.getInt(6)));
            }
        }catch (Exception e){
        }
        return list;
    }

    // load binh luan (comment)
    public List<comment> DisplayComment(int masp){
        List<comment> list = new ArrayList<>();
        String sql = "SELECT c.username,c.content FROM comment c " +
                "JOIN products p on c.productId = p.id where c.productId = ?";
        try {
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,masp);
            rs = ps.executeQuery();
            while (rs.next()){
                list.add(new comment(rs.getInt(1),rs.getString(2),
                        rs.getString(3), rs.getInt(4)));
            }
        }catch (Exception e){
        }
        return list;
    }

    // them binh luan (comment)
    public void insertComment(String name,String content,int masp){
        String sql = "INSERT into `comment`(username,content,productId) VALUES(?,?,?)";
        try {
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            ps.setString(2,content);
            ps.setInt(3,masp);
            ps.executeUpdate();
        }catch (Exception e){

        }
    }

    // x??a ng?????i d??ng
    public void deleteUser(int id){
        String sql = "DELETE FROM `user` WHERE id = ?";
        try {
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        }catch (Exception e){

        }
    }

    // th??m ng?????i d??ng
    public void insertUser(String username,String pass,String fullname,int role,String address){
        String sql = "INSERT into `user`(`user`,pass,fullname,role,address) VALUES(?,?,?,?,?)";
        try {
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,pass);
            ps.setString(3,fullname);
            ps.setInt(4,role);
            ps.setString(5,address);
            ps.executeUpdate();
        }catch (Exception e){

        }
    }

    // l???y ra ng?????i d??ng vs m?? id  (This method for part Update User)
    public  User getUserById(int id){
        String sql ="SELECT id,`user`,pass,fullname,address,role FROM `user`WHERE id = ?";
        try {
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            if(rs.next()) {
                return  new User(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getInt(6));
            }
        }catch (Exception e){

        }
        return  null;
    }

    // update ng?????i d??ng
    public void updateUser(int id,String username,String pass,String fullname,int role,String address){
        String sql = "UPDATE `user` set `user`=?,pass =?,fullname =?,\n" +
                "role = ?,address =?\n" +
                "WHERE id = ?";
        try {
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,pass);
            ps.setString(3,fullname);
            ps.setInt(4,role);
            ps.setString(5,address);
            ps.setInt(6,id);
            ps.executeUpdate();
        }catch (Exception e){

        }
    }

   // T??nh t???ng s???n ph???m
    public int totalProducts(){
        String sql = "SELECT COUNT(id)  FROM products";
        int total =0;
        try {
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
             while (rs.next()){
                 total = rs.getInt(1);
             }
        }catch (Exception e){
        }
        return total;
    }

    // T??nh t???ng kh??ch h??ng
    public int totalCustomer(){
        String sql = "SELECT COUNT(userId)  FROM orders";
        int total =0;
        try {
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                total = rs.getInt(1);
            }
        }catch (Exception e){
        }
        return total;
    }

    // T??nh t???ng ????n h??ng
    public int totalOder(){
        String sql = "SELECT COUNT(orderId)  FROM orders";
        int total =0;
        try {
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                total = rs.getInt(1);
            }
        }catch (Exception e){
        }
        return total;
    }

    // T??nh t???ng doanh thu
    public int totalDoanhThu(){
        String sql = "SELECT SUM(price) FROM orderdetail";
        int total =0;
        try {
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                total = rs.getInt(1);
            }
        }catch (Exception e){
        }
        return total;
    }
    public static void main(String[] args) {
        DAO productDAO = new DAO();
        System.out.println(productDAO.totalProducts());
//        List<User> products = productDAO.getAllCustomer();
//        for (User product : products) {
//            System.out.println(product);
//        }

    }
}

