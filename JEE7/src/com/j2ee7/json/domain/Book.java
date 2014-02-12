package com.j2ee7.json.domain;

public class Book {

	private String isbn;
	private String title;
	private String author;
	private double price;
	
	
	// Getters and Setters
	
	/**
	 * Get the isbn for the book
	 * @return isbn
	 */
	public String getIsbn() {
		
		return isbn;
	
	} // end getIsbn()
	
	
	/**
	 * Set the isbn for the book
	 * @param isbn
	 */
	public void setIsbn(String isbn) {
		
		this.isbn = isbn;
	
	} // end setIsbn()
	
	
	/**
	 * Get the title of the book
	 * @return title
	 */
	public String getTitle() {
		
		return title;
	
	} // end getTitle()
	
	
	/**
	 * Set the title of the book
	 * @param title
	 */
	public void setTitle(String title) {
		
		this.title = title;
	
	} // end setTitle()
	
	
	/**
	 * Get the author of the book
	 * @return author
	 */
	public String getAuthor() {
		
		return author;
	
	} // end getAuthor()
	
	
	/**
	 * Set the author of the book
	 * @param author
	 */
	public void setAuthor(String author) {
		
		this.author = author;
	
	} // end setAuthor()
	
	
	/**
	 * Get the price of the book
	 * @return price
	 */
	public double getPrice() {
		
		return price;
	
	} // end getPrice()
	
	
	/**
	 * Set the price of the book
	 * @param price
	 */
	public void setPrice(double price) {
		
		this.price = price;
	
	} // end setPrice()
	
	
	public String toString() {
		
		return String.format("%s%s\n%s%s\n%s%s\n%s%.2f",
				"isbn: ", getIsbn(), "title: ", getTitle(),
				"author: ", getAuthor(), "price: ", getPrice());
		
	} // end toString()
	
} // 
