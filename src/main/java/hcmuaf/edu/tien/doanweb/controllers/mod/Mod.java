package hcmuaf.edu.tien.doanweb.controllers.mod;

import hcmuaf.edu.tien.doanweb.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Mod", value = "/mod/Mod")
public class Mod extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User acc = (User) session.getAttribute("acc");
        if(acc == null ){
            request.setAttribute("error","Bạn không có quyền truy cập");
            response.sendRedirect("../login.jsp");
        }
        response.sendRedirect("../index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
