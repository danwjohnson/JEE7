package com.j2ee7.json;

import javax.json.Json;
import javax.json.JsonObject;

public class BookJsonBuilder {

	public JsonObject buildBook() {
		
		return Json.createObjectBuilder()
				.add("book", Json.createObjectBuilder()
				.add("isbn", "123456789")
				.add("title", "Alogrithm2")
				.add("author", Json.createArrayBuilder()                                        
						.add("Dan")                                        
						.add("W")                                        
						.add("Johnson"))
				.add("price", 45.78)).build();
		
	} // end buildBook() 
	
} // end BookJsonBuilder class
