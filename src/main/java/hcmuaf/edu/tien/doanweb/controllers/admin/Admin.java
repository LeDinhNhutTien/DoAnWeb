package hcmuaf.edu.tien.doanweb.controllers.admin;

import hcmuaf.edu.tien.doanweb.dao.DAO;
import hcmuaf.edu.tien.doanweb.entities.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Admin", value = "/admin")
public class Admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User acc = (User) session.getAttribute("acc");
        if(acc == null ||(acc.getRole() == 0)){
            request.setAttribute("error","Bạn không có quyền truy cập");
            response.sendRedirect("login.jsp");
            return;
        }
        DAO dao = new DAO();
        int totalProduct = dao.totalProducts();
        int totalCustomer = dao.totalCustomer();
        int totalOder = dao.totalOder();
        int totalDoanhThu = dao.totalDoanhThu();

        request.setAttribute("totalProduct",totalProduct);
        request.setAttribute("totalCustomer",totalCustomer);
        request.setAttribute("totalOder",totalOder);
        request.setAttribute("totalDoanhThu",totalDoanhThu);
        request.getRequestDispatcher("index_admin.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
