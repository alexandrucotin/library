package models;

import java.util.Date;

public class Order {
	private String idOrder;
	private Date orderDay;
	private String orderContent;
	private String idUser;
	private int totalPrice;
	private int points;
	private String bookCardId;
	private String paymentType;
	
	public String getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}
	public Date getOrderDay() {
		return orderDay;
	}
	public void setOrderDay(Date orderDay) {
		this.orderDay = orderDay;
	}
	public String getOrderContent() {
		return orderContent;
	}
	public void setOrderContent(String orderContent) {
		this.orderContent = orderContent;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getBookCardId() {
		return bookCardId;
	}
	public void setBookCardId(String bookCardId) {
		this.bookCardId = bookCardId;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

}
