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

@WebServlet("/AddMedicineServlet")
public class AddMedicineServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		try {
		Medicine m= new Medicine();
		m.setName((String)request.getParameter("name"));
		m.setCategory((String)request.getParameter("category"));
		String expiryStr = request.getParameter("expiry"); // "2025-09-15"
		java.sql.Date expiryDate = java.sql.Date.valueOf(expiryStr);
		m.setExpiryDate(expiryDate);
		m.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		m.setSupplier((String)request.getParameter("supplier"));
		HttpSession session=request.getSession();
		MedicineDao.addMedicine(m.getName(), m.getCategory(), m.getQuantity(), m.getExpiryDate(), m.getSupplier(),(String)session.getAttribute("username"));
		response.sendRedirect("addMedicine.jsp");
		}catch (Exception e) {
			e.printStackTrace();
		}
	 }
}

