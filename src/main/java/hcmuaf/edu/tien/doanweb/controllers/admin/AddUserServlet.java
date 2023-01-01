package hcmuaf.edu.tien.doanweb.controllers.admin;

import hcmuaf.edu.tien.doanweb.dao.DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddUserServlet", value = "/addUser")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("username");
        String pass  = request.getParameter("pass");
        String fullname = request.getParameter("fullname");
        String address = request.getParameter("address");
        int role = Integer.parseInt(request.getParameter("role"));

        DAO dao = new DAO();
        dao.insertUser(uname,pass,fullname,role,address);

        response.sendRedirect("listUser");
    }
}
