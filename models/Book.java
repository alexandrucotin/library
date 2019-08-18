package models;

import java.math.BigDecimal;
import java.util.Date;

public class Book {
	private String isbn;
	private String title;
	private String author;
	private String publishing_house;
	private String publication_year;
	private String category;
	private Integer price;
	private String description;
	private Integer points;
	private Integer bought_times;

	public String getPublication_year() {
		return publication_year;
	}
	public void setPublication_year(String publication_year) {
		this.publication_year = publication_year;
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
	public String getPublishing_house() {
		return publishing_house;
	}

	public void setPublishing_house(String publishing_house) {
		this.publishing_house = publishing_house;
	}

	
	

	public Integer getBought_times() {
		return bought_times;
	}

	public void setBought_times(Integer bought_times) {
		this.bought_times = bought_times;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	
	
}
