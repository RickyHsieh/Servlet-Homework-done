package webProjectDAO.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import connectionUtil.connectionUtilImpl.MyConnectionUtilImpl;
import webProjectDAO.WebProjectDAO;
import webProjectDAO.bean.AboutMe;
import webProjectDAO.bean.Order;
import webProjectDAO.bean.PageBean;
import webProjectDAO.bean.WebBoardCast;

public class WebProjectDAOImpl implements WebProjectDAO {

	@Override
	public PageBean getOrder(String orderNum, String productName, int page) {
		
		int pages = 1;
		
		PageBean pgBean = new PageBean();
		
		List<Object> ordersList = new ArrayList<>();
		
		MyConnectionUtilImpl connUtil = new MyConnectionUtilImpl();
		Connection conn = null;
		// 轉千分位
		DecimalFormat df = new DecimalFormat("#,###");
		// 轉換日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		String sql = "SELECT * FROM WEB_ORDERS wo WHERE 1 = 1 ";
			
		try {
			conn = connUtil.getConnection();
			Statement stmt = conn.createStatement();

			if (!"".equals(orderNum)) {
				sql += "AND ORDER_NO = '" + orderNum + "'";
			}
			if (!"".equals(productName)) {
				sql += "AND PRODUCT LIKE '%" + productName + "%'";
			}
			
			int start = page * 10 - 9;
			int end = page * 10;
			String pageSql = "SELECT * FROM ( SELECT rownum RN , wo.* FROM ( " + sql + " ) wo WHERE rownum <=" + end + " ) WHERE RN >= " + start;
			//確認sql語句
			System.out.println(pageSql);
			
			
			//count總共有幾筆
			String countSql = "SELECT COUNT(*) AS COUNT FROM (" + sql + ")";
			ResultSet rsCount = stmt.executeQuery(countSql);
			//一頁十筆有幾頁
			int count = 0;
			if(rsCount.next()) {
				count = rsCount.getInt(1);
			}
			pages = count / 10 + (count % 10 !=0 ? 1:0);
			ResultSet rs = stmt.executeQuery(pageSql);
			
			while (rs.next()) {

				// 先轉成Integer，再轉回String
				String formatUnitAmt = df.format(Integer.parseInt(rs.getString("UNIT_AMT")));
				String formatQty = df.format(rs.getInt("QTY"));
				String formatTotalAmt = df.format(rs.getInt("TOTAL_AMT"));

				Order order = new Order();
				order.setOrderNo(rs.getString("ORDER_NO"));
				order.setProduct(rs.getString("PRODUCT"));
				order.setUnitAmt(formatUnitAmt);
				order.setQty(formatQty);
				order.setTotalAmt(formatTotalAmt);
//				order.setBuyTime(rs.getString("BUY_TIME"));
//				sdf.format(rs.getString("PRODUCT"));

				if (rs.getDate("BUY_TIME") != null) {
					String date = sdf.format(rs.getDate("BUY_TIME"));
					System.out.println(date);
//				Date parseDate = sdf.parse(date);
//				System.out.println(parseDate);
					order.setBuyTime(date);
				} else {
					order.setBuyTime("");
				}
				ordersList.add(order);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		pgBean.setPageCount(pages);
		pgBean.setDataList(ordersList);
		return pgBean;
	}

	@Override
	public List<WebBoardCast> sellectAll() {

		MyConnectionUtilImpl connUtil = new MyConnectionUtilImpl();
		String sql = "SELECT ID,AUTH,LINK,TITLE,BEGIN_TIME FROM WEB_BROADCAST";
		List<WebBoardCast> webBoardCastList = new ArrayList<>();
		Connection conn = null;
		try {
			conn = connUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				WebBoardCast wb = new WebBoardCast();
				wb.setId(rs.getInt("ID"));
				wb.setTitle(rs.getString("TITLE"));
				wb.setLink(rs.getString("LINK"));
				wb.setBeginTime(rs.getString("BEGIN_TIME"));
				wb.setAuth(rs.getString("AUTH"));
				webBoardCastList.add(wb);
			}
			System.out.println("資料讀取完成");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return webBoardCastList;
	}

	@Override
	public List<AboutMe> getUserInfo() {
		MyConnectionUtilImpl connUtil = new MyConnectionUtilImpl();
		String sql = "SELECT ID,USERNAME,PASSWORD,CNAME,ENAME FROM WEB_EMPLOYEE WHERE ID = 2 ";
		Connection conn = null;
		List<AboutMe> user = new ArrayList<>();

		try {
			conn = connUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				AboutMe about = new AboutMe();
				about.setId(rs.getInt("ID"));
				about.setUserName(rs.getString("USERNAME"));
				about.setPassword(rs.getString("PASSWORD"));
				about.setcName(rs.getString("CNAME"));
				about.seteName(rs.getString("ENAME"));
				user.add(about);

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}

}
