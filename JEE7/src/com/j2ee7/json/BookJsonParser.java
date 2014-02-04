package com.j2ee7.json;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.json.Json;
import javax.json.stream.JsonParser;

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
