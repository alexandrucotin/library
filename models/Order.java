package models;

import java.util.Date;

public class Order {
	private String idorder;
	private String iduser;
	private String order_content;
	private String order_day;
	private Integer tot_price;
	private Integer points;
	private String bookcard_id;
	private String payment_type;
	
	public String getIdorder() {
		return idorder;
	}
	public void setIdorder(String idorder) {
		this.idorder = idorder;
	}
	public String getOrder_day() {
		return order_day;
	}
	public void setOrder_day(String order_day) {
		this.order_day = order_day;
	}
	public String getOrder_content() {
		return order_content;
	}
	public void setOrder_content(String order_content) {
		this.order_content = order_content;
	}
	public String getIduser() {
		return iduser;
	}
	public void setIduser(String iduser) {
		this.iduser = iduser;
	}
	public Integer getTot_price() {
		return tot_price;
	}
	public void setTot_price(Integer tot_price) {
		this.tot_price = tot_price;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public String getBookcard_id() {
		return bookcard_id;
	}
	public void setBookcard_id(String bookcard_id) {
		this.bookcard_id = bookcard_id;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	


}
