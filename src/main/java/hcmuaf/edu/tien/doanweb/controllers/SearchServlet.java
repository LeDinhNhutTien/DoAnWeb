package hcmuaf.edu.tien.doanweb.controllers;

import hcmuaf.edu.tien.doanweb.dao.DAO;
import hcmuaf.edu.tien.doanweb.entities.Categary;
import hcmuaf.edu.tien.doanweb.entities.ProductEntity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchServlet", value = "/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txtSearch = request.getParameter("txt");
        DAO dao = new DAO();
        List<ProductEntity> list = dao.searchByName(txtSearch);
        List<Categary> listCate = dao.getAllCategary();

        //
        request.setAttribute("listPro",list);
        request.setAttribute("listC",listCate);
        request.getRequestDispatcher("product.jsp").forward(request,response);

    }
}
