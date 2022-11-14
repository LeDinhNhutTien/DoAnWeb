package hcmuaf.edu.tien.doanweb.dao;

import hcmuaf.edu.tien.doanweb.entities.Account;
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

    public List<ProductEntity> getAllProduct() {
        List<ProductEntity> products = new ArrayList<>();
        String sql = "SELECT * FROM products ";
        try {
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ProductEntity product = new ProductEntity();

                product.setId(rs.getLong("id"));
                product.setTitle(rs.getString("title"));
                product.setPrice(rs.getLong("price"));
//                product.setSize(rs.getString("size"));
//                product.setColor(rs.getString("color"));
//                product.setDescription(rs.getString("description"));
                product.setImage(rs.getString("image"));

                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
    public Account login(String user, String pass){
        String query = "select * from account \n" + "where user = ?\n" + "and pass = ?";
        try {
            conn = ConnectionUtil.getConnection(); // mo ket noi voi mysql
            ps = conn.prepareStatement(query);
            ps.setString(1,user);
            ps.setString(2,pass);
            rs = ps.executeQuery();
            while (rs.next()){
                return  new Account(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getInt(4),rs.getInt(5));
            }
        }
        catch (Exception e){

        }
        return null;
    }
    // kiểm tra tài khoản đã tồn tại hay chưa
    public Account checkAccountExits(String user){
        String query = "select * from account \n" + "where user = ?\n" + "and pass = ?";
        try {
            conn = ConnectionUtil.getConnection(); // mo ket noi voi mysql
            ps = conn.prepareStatement(query);
            ps.setString(1,user);
            rs = ps.executeQuery();
            while (rs.next()){
                return  new Account(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getInt(4),rs.getInt(5));
            }
        }
        catch (Exception e){

        }
        return null;
    }
    // đăng ký tk
    public  void sign_up(String user, String pass){
        String query = "insert into account" + "values(0,?,?,0,0)";
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
        List<ProductEntity> products = productDAO.getAllProduct();
        for (ProductEntity product : products) {
            System.out.println(product);
        }
    }
}

