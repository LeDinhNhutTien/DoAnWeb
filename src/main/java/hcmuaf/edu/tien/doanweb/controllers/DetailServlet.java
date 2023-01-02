package hcmuaf.edu.tien.doanweb.controllers;

import hcmuaf.edu.tien.doanweb.dao.DAO;
import hcmuaf.edu.tien.doanweb.entities.Categary;
import hcmuaf.edu.tien.doanweb.entities.Product;
import hcmuaf.edu.tien.doanweb.entities.comment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DetailServlet", value = "/detail")
public class DetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String content = request.getParameter("content");
//        String username = request.getParameter("username");
        int id = Integer.parseInt(request.getParameter("pid"));
        DAO dao = new DAO();
        Product p = dao.getProductByID(id);
        List<Categary> listCate = dao.getAllCategary();

//        dao.insertComment(username,content,id); // them comment
//        List<comment> listComment = dao.DisplayComment(id);

        request.setAttribute("detail",p);
        request.setAttribute("listC",listCate);
     //   request.setAttribute("listComment",listComment);
        request.getRequestDispatcher("detail.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
