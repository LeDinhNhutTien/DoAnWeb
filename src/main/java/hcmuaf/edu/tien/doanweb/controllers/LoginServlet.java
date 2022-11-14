package hcmuaf.edu.tien.doanweb.controllers;

import hcmuaf.edu.tien.doanweb.dao.DAO;
import hcmuaf.edu.tien.doanweb.entities.Account;

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
        response.setContentType("text/html; charset= UTF-8");
        String username  = request.getParameter("username");
        String password  = request.getParameter("pass");
        DAO dao = new DAO();
        Account a = dao.login(username,password);
        if (a == null){
            request.setAttribute("mess","Tên tài khoản hoặc mật khẩu sai");
            request.getRequestDispatcher("login.jsp").forward(request,response);

        }else{
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}
