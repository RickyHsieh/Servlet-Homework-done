package webProjectServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webProjectDAO.bean.WebBoardCast;
import webProjectDAO.impl.WebProjectDAOImpl;

@WebServlet("/m001")
public class WebBoardCastServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		WebProjectDAOImpl dao = new WebProjectDAOImpl();
		List<WebBoardCast> webBoardCastsInfo = dao.sellectAll();
		

		request.setAttribute("wbInfo", webBoardCastsInfo);
		request.getRequestDispatcher("M001.jsp").forward(request, response);;
		
	}

}
