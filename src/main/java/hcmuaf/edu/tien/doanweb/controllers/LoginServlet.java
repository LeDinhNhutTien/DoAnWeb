package hcmuaf.edu.tien.doanweb.controllers;

import hcmuaf.edu.tien.doanweb.dao.DAO;
import hcmuaf.edu.tien.doanweb.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username  = request.getParameter("username");
        String password  = request.getParameter("pass");
        DAO dao = new DAO();
        User a = dao.login(username,password);
        if (a == null){ // tài khoản ko tồn tại
            request.setAttribute("error","Tên tài khoản hoặc mật khẩu sai"); // báo lỗi
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }else{
            HttpSession session = request.getSession(true);
            session.setAttribute("acc",a);
            response.sendRedirect("home");
        }
    }
}
