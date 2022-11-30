package hcmuaf.edu.tien.doanweb.controllers;

import hcmuaf.edu.tien.doanweb.dao.DAO;
import hcmuaf.edu.tien.doanweb.entities.Categary;
import hcmuaf.edu.tien.doanweb.entities.ProductEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "HomeControl", value = "/shop")
public class ShopServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // nhan du lieu tu DAO
        DAO dao = new DAO();
        List<ProductEntity> listPro = dao.getAllProduct();
        List<Categary> listCate = dao.getAllCategary();


            // set du lieu den jsp
        request.setAttribute("listPro",listPro);
        request.setAttribute("listC",listCate);
        request.getRequestDispatcher("product.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
