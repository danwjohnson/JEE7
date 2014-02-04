package com.j2ee7.json;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.json.Json;
import javax.json.stream.JsonParser;

public class BookJsonParser {

	public String parseBookAndGetTitle() {
		
		String title = "";
		
		try {
			
			JsonParser parser = Json.createParser(new FileReader("book.json"));
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
		catch (FileNotFoundException ex) {} // end catch
			
		return title;
		
	} // end parseBookAndGetTitle()
	
} // end BookJsonParser class
