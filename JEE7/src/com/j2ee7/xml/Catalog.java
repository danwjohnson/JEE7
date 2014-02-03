package com.j2ee7.xml;

public class Catalog {

	private String title;
	private String publishDate;
	private String author;
	private String link;
	
	
	public Catalog(String title, String publishDate, String author, String link) {
		super();
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
		this.link = link;
	}
	
	public Catalog() {
		
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	
	
	public String toString() {
		
		return String.format("Title: %s\n"
				+ "Publish Date: %s\n"
				+ "Author: %s\n"
				+ "Link: %s\n",
				getTitle(), getPublishDate(), getAuthor(),
				getLink());
		
	} // end toString()

} // end Catalog class
