package com.j2ee7.json;

import java.io.IOException;

public class EmployeeJSONWriterTest {

	public static void main(String args[]) throws IOException {
		
		EmployeeJSONWriter empWriter = new EmployeeJSONWriter();
		
		empWriter.writeEmployeeJSON("emp.json");
		
	} // end main
	
} // end EmployeeJSONWriterTest class
