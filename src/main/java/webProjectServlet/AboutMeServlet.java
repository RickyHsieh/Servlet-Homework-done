package webProjectServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webProjectDAO.bean.AboutMe;
import webProjectDAO.impl.WebProjectDAOImpl;


@WebServlet("/about")
public class AboutMeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		WebProjectDAOImpl dao = new WebProjectDAOImpl();
		List<AboutMe> userInfo = dao.getUserInfo();
		
		request.setAttribute("user", userInfo);
		request.getRequestDispatcher("about.jsp").forward(request, response);
	
	
	
	
	}

}
