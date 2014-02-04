package com.j2ee7.json;

import java.io.FileWriter;
import java.io.IOException;

import javax.json.JsonObject;

public class BookJsonBuilderTest {

	public static void main(String args[]) {
		
		BookJsonBuilder bookJsonBuilder = new BookJsonBuilder();
		JsonObject jsonObject = bookJsonBuilder.buildBook();
		
		try {
			
			FileWriter file = new FileWriter("book2.json");
			file.write(jsonObject.toString());
			file.flush();
			file.close();
			
		} // end try
		catch(IOException ex) {
			
			ex.printStackTrace();
			
		} // end catch
		
	} // end main
	
} // end BookJsonBuilderTest class
