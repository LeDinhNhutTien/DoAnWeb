package hcmuaf.edu.tien.doanweb.controllers;

import hcmuaf.edu.tien.doanweb.dao.DAO;
import hcmuaf.edu.tien.doanweb.entities.Cart;
import hcmuaf.edu.tien.doanweb.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckoutServlet", value = "/checkout")
public class CheckoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        DAO dao = new DAO();
        Cart cart =null;
        Object o = session.getAttribute("cart");
        // co roi
        if(o!=null){
            cart = (Cart) o;
        }else {
            cart = new Cart();
        }
        User acount = null;
        Object a = session.getAttribute("acc");
        if (a!=null){
            acount = (User) a;
            dao.addOrder(acount,cart);
            session.removeAttribute("cart");
            session.setAttribute("size",0);
            session.setAttribute("totalMoney",0);
           // response.sendRedirect("index.jsp");
            response.sendRedirect("home");
        }else {
            response.sendRedirect("login.jsp");
        }
    }
}
