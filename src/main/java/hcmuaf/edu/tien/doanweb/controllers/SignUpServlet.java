package hcmuaf.edu.tien.doanweb.controllers;

import hcmuaf.edu.tien.doanweb.dao.DAO;
import hcmuaf.edu.tien.doanweb.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SignUpServlet", value = "/signUp")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user_name");
        String pass = request.getParameter("user_password");
        String repass = request.getParameter("rePassword");
        if (!pass.equals(repass)){
            request.setAttribute("mess","Mật khẩu không khớp");
            request.getRequestDispatcher("sign_up.jsp").forward(request,response);
        }
        else{
            DAO dao = new DAO();
            User a = dao.checkAccountExits(user);
            if(a == null){ // chưa có tài khoản
                dao.sign_up(user,pass);
                response.sendRedirect("login.jsp");
            }
            else{ // đã tồn tại tài khoản
                request.setAttribute("mess","Tài khoản đã tồn tại");
                request.getRequestDispatcher("sign_up.jsp").forward(request,response);
            }
        }
    }
}
