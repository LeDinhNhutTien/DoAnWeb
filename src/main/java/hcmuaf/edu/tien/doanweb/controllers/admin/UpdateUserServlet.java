package hcmuaf.edu.tien.doanweb.controllers.admin;

import hcmuaf.edu.tien.doanweb.dao.DAO;
import hcmuaf.edu.tien.doanweb.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.DataInput;
import java.io.IOException;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("uid"));
        DAO dao = new DAO();
        User user = dao.getUserById(id);
        request.setAttribute("userUpdate",user);
        request.getRequestDispatcher("form-update-user.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String uname = request.getParameter("username");
        String pass  = request.getParameter("pass");
        String fullname = request.getParameter("fullname");
        String address = request.getParameter("address");
        int role = Integer.parseInt(request.getParameter("role"));

        DAO dao = new DAO();
        dao.updateUser(id,uname,pass,fullname,role,address);
        response.sendRedirect("listUser");
    }
}
