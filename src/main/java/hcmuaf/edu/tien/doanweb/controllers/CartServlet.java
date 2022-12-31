package hcmuaf.edu.tien.doanweb.controllers;

import hcmuaf.edu.tien.doanweb.dao.DAO;
import hcmuaf.edu.tien.doanweb.entities.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CartServlet", value = "/buy")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Cart cart = null;
        Object o = session.getAttribute("cart");
        // co roi
        if(o!=null){
            cart = (Cart) o;
        }else {
            cart = new Cart();
        }
        int id = Integer.parseInt(request.getParameter("id"));
        int num =Integer.parseInt(request.getParameter("num")); // moi lan them vao gio hang 1 cai
        DAO dao = new DAO();
        Product p = dao.getProductByID(id);
        int price = p.getPrice();
        Item t = new Item(p,num,price);
        cart.addItem(t); // them

        List<Item> list = cart.getItems();
        // load sp va danh muc sp
        List<Product> listPro = dao.getAllProduct();
        List<Categary> listCate = dao.getAllCategary();
        request.setAttribute("listPro",listPro);
        request.setAttribute("listC",listCate);

        // su ly du lieu cua phan gio hang
        session.setAttribute("cart",cart);
        // số lượng món đồ trong giỏ
        session.setAttribute("size",list.size());
        // set lại tổng tiền all các món đồ trong giỏ hàng
        session.setAttribute("totalMoney",cart.getTotalMoney());

        response.sendRedirect("listProducts");
    }
}

