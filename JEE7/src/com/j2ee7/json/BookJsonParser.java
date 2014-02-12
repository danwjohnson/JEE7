package com.j2ee7.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import javax.json.Json;
import javax.json.stream.JsonParser;

import com.j2ee7.json.domain.Book;

public class BookJsonParser {

	
	private String fileName;
	
	public BookJsonParser(String fileName) {
		
		this.fileName = fileName;
		
	} // end constructor
	
	
	/**
	 * Parse the json file
	 */
	public void parseJson() {
		
		JsonParser parser = createParser();
		String title = parseBookAndGetTitle(parser);
		
		System.out.println ("Book title: " + title);
		System.out.println("\n\nStarting to parse all book titles");
		
		// reset the parser
		parser.close();
		parser = createParser();
		
		// Begin parsing again
		ArrayList<String> titles = new ArrayList<String>();
		titles = parseAllBookTitles(parser);
		
		Iterator<String> iter = titles.iterator();
		
		while(iter.hasNext()) {
			
			System.out.println("Book: " + iter.next());
			
		} // end while loop
		
		
		// reset the parser
		parser.close();
		parser = createParser();
		
		// Begin parsing again
		System.out.println("\n\nParsing JSON file into Book object");
		ArrayList<Book> books = new ArrayList<Book>();
		books = parseAllBooks(parser);
		
		Iterator<Book> iterBooks = books.iterator();
		
		while (iterBooks.hasNext()) {
			
			System.out.println(iterBooks.next());
			
		} // end while loop
		
	} // end parseJson()
	
	
	
	/**
	 * Parse the book json file and get the title
	 * @param parser
	 * @return String title
	 */
	private String parseBookAndGetTitle(JsonParser parser) {
		
		String title = "";
		
		try {
			
			while (parser.hasNext()) {
				
				JsonParser.Event event = parser.next();
				while (parser.hasNext() && !(event.equals(JsonParser.Event.KEY_NAME) 
						&& parser.getString().matches("title"))) {
					
					event = parser.next();
					
				} // end while loop
				
				if (event.equals(JsonParser.Event.KEY_NAME) && 
						parser.getString().matches("title")) {
					
					parser.next();
					title = parser.getString();
					
				} // end if
				
			} // end while loop
			
		} // end try
		catch (Exception ex) {} // end catch
			
		return title;
		
	} // end parseBookAndGetTitle()
	
	
	private ArrayList<String> parseAllBookTitles(JsonParser parser) {
		
		ArrayList<String> titles = new ArrayList<String>();
		
		try {
			
			while (parser.hasNext()) {
				
				JsonParser.Event event = parser.next();
				while (parser.hasNext() && !(event.equals(JsonParser.Event.KEY_NAME)
						&& parser.getString().matches("title"))) {
					
					event = parser.next();
					
				} // end inner while loop
				
				if (event.equals(JsonParser.Event.KEY_NAME) &&
						parser.getString().matches("title")) {
					
					parser.next();
					titles.add(parser.getString());
					
				} // end if
				
			} // end while loop
			
		} // end try
		catch (Exception ex) {}	// end catch
		
		return titles;
		
	} // end parseAllBookTitles()
	
	
	private ArrayList<Book> parseAllBooks(JsonParser parser) {
		
		String[] author = new String[3];
		StringBuilder tempString = new StringBuilder();
		ArrayList<Book> books = new ArrayList<Book>();
		Book book = new Book();
		
		try {
			
			while(parser.hasNext()) {
				
				JsonParser.Event event = parser.next();
				while (parser.hasNext() && !(event.equals(JsonParser.Event.KEY_NAME)
						&& (parser.getString().matches("isbn")
						|| parser.getString().matches("title")
						|| parser.getString().matches("author")
						|| parser.getString().matches("price")))) {
					
					event = parser.next();
					
				} // end inner while loop
				
				if (event.equals(JsonParser.Event.KEY_NAME) &&
						parser.getString().matches("isbn")) {
					
					parser.next();
					book.setIsbn(parser.getString());
					
				} // end if

				
				if (event.equals(JsonParser.Event.KEY_NAME) &&
						parser.getString().matches("title")) {
					
					parser.next();
					book.setTitle(parser.getString());
					
				} // end if
							
				if (event.equals(JsonParser.Event.KEY_NAME) &&
						parser.getString().matches("author")) {
					
					parser.next();
					parser.next();
					for(int i = 0; i < 3; i++) {
						
						author[i] = parser.getString();
						parser.next();
						
					}
					
					for (int i = 0; i < author.length; i++) {
						
						tempString.append(author[i]);
						
					}
					
					book.setAuthor(tempString.toString());
					parser.next();
					tempString = new StringBuilder();
					
					
				} // end if
				
				if (event.equals(JsonParser.Event.KEY_NAME) &&
						parser.getString().matches("price")) {
					
					parser.next();
					book.setPrice(Float.valueOf(parser.getString()));
					parser.next();
					books.add(book);
					book = new Book();
					
				} // end if 
				
			} // end outer while loop
			
		} // end try
		catch (Exception ex) {
			
			ex.printStackTrace();
			
		} // end catch
		
		return books;
		
	} // end parseAllBooks()
	
	
	
	/**
	 * Create the JSON parser
	 * @return JsonParser parser
	 */
	private JsonParser createParser() {
		
		try {
		
			JsonParser parser = Json.createParser(new FileReader(fileName));
			return parser;
	
		}// end try
		catch (FileNotFoundException ex) {
			
			return null;
			
		} // end catch
			
	} // end createParser
	
} // end BookJsonParser class
