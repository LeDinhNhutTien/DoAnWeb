package hcmuaf.edu.tien.doanweb.controllers;

import hcmuaf.edu.tien.doanweb.dao.DAO;
import hcmuaf.edu.tien.doanweb.entities.Categary;
import hcmuaf.edu.tien.doanweb.entities.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PhanTrangServlet", value = "/listProducts")
public class PhanTrangServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String indexPage = request.getParameter("index");
        if(indexPage == null ){
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);

        // lay ra tong so sp
        DAO dao = new DAO();
        int count = dao.getToltalProducts();
        int endPage = count/9;
        if(count % 9 != 0) endPage++;

        List<Product> list = dao.pagingProduct(index);
        List<Categary> listCate = dao.getAllCategary(); // load danh muc sp

        request.setAttribute("listPage",list);
        request.setAttribute("endP",endPage);
        request.setAttribute("tag",index);
        request.setAttribute("listC",listCate);
        request.getRequestDispatcher("product.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
