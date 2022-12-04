package hcmuaf.edu.tien.doanweb.dao;

import hcmuaf.edu.tien.doanweb.entities.Categary;
import hcmuaf.edu.tien.doanweb.entities.User;
import hcmuaf.edu.tien.doanweb.entities.ProductEntity;
import hcmuaf.edu.tien.doanweb.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private Connection conn = null;
    private PreparedStatement ps = null;
    protected ResultSet rs = null;

    // load san pham
    public List<ProductEntity> getAllProduct() {
        List<ProductEntity> products = new ArrayList<>();
        String sql = "SELECT id,name,price,image,description FROM products ";
        try {
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
            products.add(new ProductEntity(rs.getInt(1),
                    rs.getString(2), rs.getDouble(3),
                    rs.getString(4),rs.getString(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
    // lấy ra những ở sp từng danh muc
    public List<ProductEntity> getProductByCateID(String cid) {
        List<ProductEntity> products = new ArrayList<>();
        String sql = "SELECT id,name,price,image,description FROM products WHERE cateID = ?";
        try {
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,cid);
            rs = ps.executeQuery();

            while (rs.next()) {
                products.add(new ProductEntity(rs.getInt(1),
                        rs.getString(2), rs.getDouble(3),
                        rs.getString(4),rs.getString(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
    // lấy ra sp có id
    public ProductEntity getProductByID(String id) {
        String sql = "SELECT id,name,price,image,description FROM products WHERE id = ?";
        try {
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,id);
            rs = ps.executeQuery();

            while (rs.next()) {
                return new ProductEntity(rs.getInt(1),
                        rs.getString(2), rs.getDouble(3),
                        rs.getString(4),rs.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // tim kiem sp
    public List<ProductEntity> searchByName(String txtSearch) {
        List<ProductEntity> products = new ArrayList<>();
        String sql = "SELECT id,name,price,image,description FROM products WHERE name like ?";
        try {
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1,"%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                products.add(new ProductEntity(rs.getInt(1),
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
        String query = "select id,user,pass,fullname,role from account \n" + "where user = ?\n" + "and pass = ?";
        try {
            conn = ConnectionUtil.getConnection(); // mo ket noi voi mysql
            ps = conn.prepareStatement(query);
            ps.setString(1,user);
            ps.setString(2,pass);
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
    // kiểm tra tài khoản đã tồn tại hay chưa
    public User checkAccountExits(String user){
        String query = "select id,user,pass,fullname,role from account \n" + "where user = ?\n" + "and pass = ?";
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
        String query = "insert into account(`user`,pass,role)"+ " values(?,?,0)";
        try {
            conn = ConnectionUtil.getConnection(); // mo ket noi voi mysql
            ps = conn.prepareStatement(query);
            ps.setString(1,user);
            ps.setString(2,pass);
            ps.executeUpdate();
        }catch (Exception e){
        }
    }
    public static void main(String[] args) {
        DAO productDAO = new DAO();
        List<ProductEntity> products = productDAO.getProductByCateID("1");
        for (ProductEntity product : products) {
            System.out.println(product);
        }
    }
}

