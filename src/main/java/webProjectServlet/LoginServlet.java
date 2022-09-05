package webProjectServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connectionUtil.connectionUtilImpl.MyConnectionUtilImpl;
import webProjectDAO.bean.Employee;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		String username = request.getParameter("username");
		String password = request.getParameter("pwd");
		System.out.println("帳號:" + username);
		System.out.println("密碼:" + password);
		
		
		if (username!=null && !"".equals(username) && password!=null && !"".equals(password)) {
			
			MyConnectionUtilImpl connUtil = new MyConnectionUtilImpl();
			String sql = "SELECT * FROM WEB_EMPLOYEE WHERE USERNAME = ? AND PASSWORD = ? ";
			
			try {
				Connection conn = connUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				
				ResultSet rs = pstmt.executeQuery();
				
				System.out.println("執行");
				if (rs.next()) {
					
					Employee emp = new Employee();
					emp.setUsername(rs.getString("USERNAME"));
					emp.setcName(rs.getString("CNAME"));
					emp.seteName(rs.getString("ENAME"));
					
					System.out.println("登入使用者 : " + rs.getString("cName"));
					HttpSession session = request.getSession();
					session.setAttribute("userInfo",emp);
					
					response.sendRedirect("/servletHw/m001");
					return;
				}else {
					System.out.println("登入失敗");
					response.sendRedirect("/servletHw/login");
					return;
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
		
	}
		
	
}
