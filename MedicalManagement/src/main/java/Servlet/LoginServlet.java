package Servlet;

import java.io.IOException;

import Dao.OwnerDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		try {
			if(OwnerDao.validateLogin(user, pass)) {
				HttpSession session= request.getSession();
				session.setAttribute("username", user);
				response.sendRedirect("home.jsp");
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("errorLoginMessage", "Invalid username or password!");
				response.sendRedirect("login.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

