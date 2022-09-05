package webProjectDAO.bean;

import java.util.Date;

public class Order {
	private String orderNo;
	private String product;
	private String unitAmt;
	private String qty;
	private String totalAmt;
	private String buyTime;
	
	
	
	

	public String getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getUnitAmt() {
		return unitAmt;
	}
	public void setUnitAmt(String unitAmt) {
		this.unitAmt = unitAmt;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(String totalAmt) {
		this.totalAmt = totalAmt;
	}

	
}