package hcmuaf.edu.tien.doanweb.controllers;

import hcmuaf.edu.tien.doanweb.dao.DAO;
import hcmuaf.edu.tien.doanweb.entities.Categary;
import hcmuaf.edu.tien.doanweb.entities.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeControl", value = "/home")
public class ShopServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // nhan du lieu tu DAO
        DAO dao = new DAO();
        List<Product> listProductHot = dao.getProducHot();
        List<Product> listProductSell = dao.getProducSell();
        List<Product> listProductPromotion = dao.getProducPromotion();
       // List<Categary> listCate = dao.getAllCategary();


            // set du lieu den jsp
        request.setAttribute("listHot",listProductHot);
        request.setAttribute("listSell",listProductSell);
        request.setAttribute("listPromotion",listProductPromotion);
     //   request.setAttribute("listC",listCate);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
