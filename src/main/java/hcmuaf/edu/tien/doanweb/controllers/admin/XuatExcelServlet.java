package hcmuaf.edu.tien.doanweb.controllers.admin;

import hcmuaf.edu.tien.doanweb.dao.DAO;
import hcmuaf.edu.tien.doanweb.entities.ListOder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "XuatExcelServlet", value = "/export")
public class XuatExcelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAO dao = new DAO();
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition","attachment;filename=hoaDon.xls");
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet   sheet = wb.createSheet("list");
        List<ListOder> list = dao.getAllOrder();
        // tao excel
            // 1 header
        int rowNo =0;
        Row row = sheet.createRow(rowNo++);
        int cellnum =0;
        Cell cell = row.createCell(cellnum++);
        cell.setCellValue("ID đơn hàng");

        cell = row.createCell(cellnum++);
        cell.setCellValue("Khách hàng");

        cell = row.createCell(cellnum++);
        cell.setCellValue("Ngày đặt");

        cell = row.createCell(cellnum++);
        cell.setCellValue("Số lượng");

        cell = row.createCell(cellnum++);
        cell.setCellValue("Tổng tiền");

        cell = row.createCell(cellnum++);
        cell.setCellValue("Tình trạng");

            // 2 Chi tiet
        for(ListOder l: list){
            cellnum =0;
            row = sheet.createRow(rowNo++);

            cell = row.createCell(cellnum++);
            cell.setCellValue(l.getId());

            cell = row.createCell(cellnum++);
            cell.setCellValue(l.getName());

            cell = row.createCell(cellnum++);
            cell.setCellValue(l.getDate());

            cell = row.createCell(cellnum++);
            cell.setCellValue(l.getQuantity());

            cell = row.createCell(cellnum++);
            cell.setCellValue(l.getTotalMoney());

            cell = row.createCell(cellnum++);
            cell.setCellValue("Đã giao");
        }
        // ket thuc
        wb.write(response.getOutputStream());
        wb.close();
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
