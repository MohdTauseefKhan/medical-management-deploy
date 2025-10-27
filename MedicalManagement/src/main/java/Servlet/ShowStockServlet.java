package Servlet;

import java.io.IOException;
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

@WebServlet("/ShowStockServlet")
public class ShowStockServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		HttpSession session=request.getSession();
		List<Medicine> medicines= MedicineDao.getMedicineList((String)session.getAttribute("username")); 
		request.setAttribute("medicines", medicines);
		
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
        rd.forward(request, response);
	}

}
