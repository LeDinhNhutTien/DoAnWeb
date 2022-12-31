package hcmuaf.edu.tien.doanweb.controllers.admin;

import hcmuaf.edu.tien.doanweb.dao.DAO;
import hcmuaf.edu.tien.doanweb.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Admin", value = "/admin/Admin")
public class Admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User acc = (User) session.getAttribute("acc");
        if(acc == null ||(acc.getRole() == 0)){
            request.setAttribute("error","Bạn không có quyền truy cập");
            response.sendRedirect("../login.jsp");
            return;
        }
        response.sendRedirect("../quan-ly-bao-cao.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
