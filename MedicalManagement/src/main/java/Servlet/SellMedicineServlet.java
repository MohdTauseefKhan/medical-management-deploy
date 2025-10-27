package Servlet;

import java.io.IOException;

import Dao.MedicineDao;
import Model.Medicine;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/SellMedicineServlet")
public class SellMedicineServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		Medicine medicine= new Medicine();
		
		medicine.setId(Integer.parseInt((request.getParameter("id"))));
		medicine.setQuantity(Integer.parseInt((request.getParameter("quantity"))));
		
		if(MedicineDao.sellMedicine(medicine)) {
			response.sendRedirect("home.jsp");
		}else {
			response.sendRedirect("sellMedicine.jsp");
		}
	}

}
