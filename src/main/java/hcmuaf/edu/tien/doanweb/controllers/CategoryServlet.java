package hcmuaf.edu.tien.doanweb.controllers;

import hcmuaf.edu.tien.doanweb.dao.DAO;
import hcmuaf.edu.tien.doanweb.entities.Categary;
import hcmuaf.edu.tien.doanweb.entities.ProductEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/category")
public class CategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cateID = request.getParameter("cid");
        // da lay dc category ve roi
        DAO dao = new DAO();
        List<ProductEntity> list = dao.getProductByCateID(cateID);
        List<Categary> listCate = dao.getAllCategary();


        request.setAttribute("listPro",list);
        request.setAttribute("listC",listCate);
        request.getRequestDispatcher("product.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
