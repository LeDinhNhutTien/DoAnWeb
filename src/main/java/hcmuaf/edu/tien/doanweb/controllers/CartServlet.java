package hcmuaf.edu.tien.doanweb.controllers;

import hcmuaf.edu.tien.doanweb.entities.Cart2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CartServlet", value = "/cart")
public class CartServlet extends HttpServlet {
    Cart2 model = new Cart2();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int masp = Integer.parseInt(request.getParameter("txtmasp"));
        String yeucau = request.getParameter("yeucau");
        if (yeucau.equals("muasp")){
            // goi ham them sp
            model.addSanPham(masp);
            // goi ham lay danh sach cac mon hang da mua
            request.setAttribute("giohang", model.getListItems());
        }
        request.getRequestDispatcher("cart.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

