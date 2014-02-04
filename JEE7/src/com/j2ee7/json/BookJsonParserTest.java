package com.j2ee7.json;

public class BookJsonParserTest {

	public static void main(String args[]) {
		
		BookJsonParser jsonParser = new BookJsonParser();
		String title = jsonParser.parseBookAndGetTitle();
		System.out.println("Book Title: " + title);
		
	} // end main
	
} // end BookJsonParserTest classS
