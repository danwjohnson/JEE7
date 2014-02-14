package com.j2ee7.json;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import com.j2ee7.json.domain.Address;
import com.j2ee7.json.domain.Employee;

public class EmployeeJSONReader {

	public static final String JSON_FILE = "employee.json";
	
	public void readJson() {
		
		// Retrieve data from JsonObject and create Employee bean
		try {
			
			JsonObject obj = createReader(JSON_FILE);
			
			Employee emp = new Employee();
			
			emp.setId(obj.getInt("id"));
			emp.setName(obj.getString("name"));
			emp.setPermanent(obj.getBoolean("permanent"));
			emp.setRole(obj.getString("role"));
			
			// reading arrays from json
			JsonArray jsonArray = obj.getJsonArray("phoneNumbers");
			long[] numbers = new long[jsonArray.size()];
			int index = 0;
			for (JsonValue value : jsonArray)
				numbers[index++] = Long.parseLong(value.toString());
			
			emp.setPhoneNumbers(numbers);
			
			// reading inner object from json object
			JsonObject innerJsonObject = obj.getJsonObject("address");
			
			Address address = new Address();
			address.setStreet(innerJsonObject.getString("street"));
			address.setCity(innerJsonObject.getString("city"));
			address.setZipcode(innerJsonObject.getInt("zipcode"));
			emp.setAddress(address);
			
			// print employee bean information
			System.out.println(emp);
		
		} // end try
		catch (Exception ex) {
			
			ex.printStackTrace();
			
		} // end catch
		
	} // end readJson()
	
	
	private JsonObject createReader(String fileName) throws IOException {
		
		InputStream fis = new FileInputStream(fileName);
		
		// create JsonReader object
		JsonReader jsonReader = Json.createReader(fis);
		
		/**
		 * We can create JsonReader from Factory also
		 * JsonReaderFactory factory = Json.createReaderFactory(null);
		 * jsonReader = factory.createReader(fis);
		 */
		
		// get JsonObject from JsonReader
		JsonObject jsonObject = jsonReader.readObject();
		
		// we can now close IO resource and JsonReader now
		jsonReader.close();
		fis.close();
		
		return jsonObject;
		
	} // end createReader()
	
} // end EmploeeJSONReader class
