package Servlet;

import java.io.IOException;
import Dao.OwnerDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		String email = request.getParameter("email");
		String code = request.getParameter("code");
		try {
			if(OwnerDao.registerOwner(user, pass,email,code)) {
				HttpSession session = request.getSession();
				session.setAttribute("successMessage", "Registration successful! Please login.");
				response.sendRedirect("register.jsp");
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("errorMessage", "Registration Falied! Try again.");
				response.sendRedirect("register.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}}
