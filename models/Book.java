package models;

import java.math.BigDecimal;
import java.util.Date;

public class Book {
	private String isbn;
	private String author;
	private String title;
	private String publishingHouse;
	private String category;
	private BigDecimal price;
	private Date publicationDate;
	private String description;
	private int points;
	private int boughtTimes;
	
	public Book () {};
	
	public Book(String isbn, String author, String title, String publishingHouse, String category, BigDecimal price,
			Date publicationDate, String description, int points, int boughtTimes) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.publishingHouse = publishingHouse;
		this.category = category;
		this.price = price;
		this.publicationDate = publicationDate;
		this.description = description;
		this.points = points;
		this.boughtTimes = boughtTimes;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublishingHouse() {
		return publishingHouse;
	}
	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getBoughtTimes() {
		return boughtTimes;
	}
	public void setBoughtTimes(int boughtTimes) {
		this.boughtTimes = boughtTimes;
	}
	
	
}
