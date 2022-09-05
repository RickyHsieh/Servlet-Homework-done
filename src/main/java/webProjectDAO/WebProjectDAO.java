package webProjectDAO;

import java.util.List;

import webProjectDAO.bean.AboutMe;
import webProjectDAO.bean.Order;
import webProjectDAO.bean.PageBean;
import webProjectDAO.bean.WebBoardCast;


public interface WebProjectDAO {
	
	/**
	 * 透過條件 order_No 或是 productName 去查詢特定資料
	 * @param orderNum
	 * @param productName
	 * @return List<Order> 
	 */
	PageBean getOrder(String orderNum, String productName, int page);
	
	/**
	 * 取得所有WebBoardCast資料
	 * @return List<WebBoardCast>
	 */
	List<WebBoardCast> sellectAll();
	
	/**
	 * 取得單筆使用者資料
	 * @return AboutMe object
	 */
	List<AboutMe> getUserInfo();
	
	
	
}
