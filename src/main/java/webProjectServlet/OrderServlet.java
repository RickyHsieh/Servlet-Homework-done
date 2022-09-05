package webProjectServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webProjectDAO.bean.Order;
import webProjectDAO.bean.PageBean;
import webProjectDAO.impl.WebProjectDAOImpl;

@WebServlet("/m002")
public class OrderServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse reqponse) throws ServletException,IOException {
		
		String orderNum = request.getParameter("orderNum");
		String productName = request.getParameter("productName");
		
		
		int page = 1;
		if (request.getParameter("page")!= null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		WebProjectDAOImpl dao = new WebProjectDAOImpl();
		PageBean tempOrder = dao.getOrder(orderNum, productName,page);
		int count = tempOrder.getPageCount();
		List<Object> dataList = tempOrder.getDataList();
		
		System.out.println("頁面數量:" + count);
		
		request.setAttribute("tempOrder",dataList);
		request.setAttribute("pages", count);
		request.setAttribute("orderNum",orderNum != null ? orderNum : "");
		request.setAttribute("productName",productName != null ? productName : "");
		request.getRequestDispatcher("M002.jsp").forward(request, reqponse);
		
		
	}
	

}
