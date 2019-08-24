package models;

import java.util.Date;

public class BookCard {
	private String idBookCard;
	private String idUser;
	private Date issueDate;
	private int points;
	
	public String getIdBookCard() {
		return idBookCard;
	}
	public void setIdBookCard(String idBookCard) {
		this.idBookCard = idBookCard;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	
}
