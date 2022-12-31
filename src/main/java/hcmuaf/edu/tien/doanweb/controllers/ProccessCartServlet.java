package hcmuaf.edu.tien.doanweb.controllers;

import hcmuaf.edu.tien.doanweb.dao.DAO;
import hcmuaf.edu.tien.doanweb.entities.Cart;
import hcmuaf.edu.tien.doanweb.entities.Item;
import hcmuaf.edu.tien.doanweb.entities.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProcessCartServlet", value = "/proccess")
public class ProccessCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // xu ly nut tang giam so luong
        HttpSession session = request.getSession(true);
        Cart cart = null;
        Object o = session.getAttribute("cart");
        // co roi
        if(o!=null){
            cart = (Cart) o;
        }else {
            cart = new Cart();
        }
        int num = Integer.parseInt(request.getParameter("num").trim());
        int id = Integer.parseInt(request.getParameter("id"));
        // neu so luong nho hon 1 thi xoa khoi gio hang
        if ((num == -1) && (cart.getQuantityById(id) <=1)){
            cart.removeItem(id);
        }else {
            DAO dao = new DAO();
            Product p = dao.getProductByID(id);
            int price = p.getPrice();
            Item t = new Item(p,num,price);
            cart.addItem(t);
        }
        List<Item> list = cart.getItems();

        session.setAttribute("cart",cart);
        session.setAttribute("size",list.size());
        session.setAttribute("totalMoney",cart.getTotalMoney());
        request.getRequestDispatcher("cart.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // xu ly nut xoa
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
        cart.removeItem(id); // xoa

        List<Item> list = cart.getItems();

        session.setAttribute("cart",cart);
        session.setAttribute("size",list.size()); // số lượng món đồ trong giỏ
        // set lại tổng tiền all các món đồ trong giỏ hàng
        session.setAttribute("totalMoney",cart.getTotalMoney());
        request.getRequestDispatcher("cart.jsp").forward(request,response);
    }
}
