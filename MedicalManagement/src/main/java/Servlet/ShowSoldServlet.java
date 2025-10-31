package Servlet;

import java.io.IOException;
import java.net.http.HttpClient;
import java.util.List;

import Dao.MedicineDao;
import Model.Medicine;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ShowSoldStockServlet")
public class ShowSoldServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		HttpSession session=request.getSession();
		List<Medicine> medicines= MedicineDao.getSoldMedicineList((String)session.getAttribute("username")); 
		request.setAttribute("medicines", medicines);
		RequestDispatcher rd = request.getRequestDispatcher("soldMedicine.jsp");
        rd.forward(request, response);
	}

}
