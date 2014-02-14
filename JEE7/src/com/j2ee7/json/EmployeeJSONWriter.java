package com.j2ee7.json;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

import com.j2ee7.json.domain.Address;
import com.j2ee7.json.domain.Employee;

public class EmployeeJSONWriter {

	public void writeEmployeeJSON(String fileName) throws IOException {
		
		Employee emp = createEmployee();
		
		JsonObject obj = buildEmployeeJSONObject(emp);
		
		writeToFile(fileName, obj);
		
	} // end writeEmployeeJSON()

	
	private static JsonObject buildEmployeeJSONObject(Employee emp) {
		
		JsonObjectBuilder empBuilder = Json.createObjectBuilder();
		JsonObjectBuilder addressBuilder = Json.createObjectBuilder();
		
		JsonArrayBuilder phoneNumBuilder = Json.createArrayBuilder();
		
		for (long phone : emp.getPhoneNumbers())
			phoneNumBuilder.add(phone);
		
		addressBuilder.add("street", emp.getAddress().getStreet())
			.add("city", emp.getAddress().getCity())
			.add("zipcode", emp.getAddress().getZipcode());
		
		empBuilder.add("id", emp.getId())
			.add("name", emp.getName())
			.add("permanent", emp.isPermanent())
			.add("role", emp.getRole());
		
		empBuilder.add("phoneNumbers", phoneNumBuilder);
		empBuilder.add("address", addressBuilder);
		
		JsonObject empJSONObject = empBuilder.build();
		
		System.out.println("Employee JSON String\n" + empJSONObject);
		
		return empJSONObject;
		
	} // end buildEmployeeJSONObject()
	
	static Employee createEmployee() {
		
		Employee emp = new Employee();
		
		emp.setId(100);
		emp.setName("Dan");
		emp.setPermanent(false);
		emp.setPhoneNumbers(new long[] {123456, 7890987});
		emp.setRole("Dude");
		
		Address add = new Address();
		add.setCity("Huntley");
		add.setStreet("11292 Kingsbury Ct");
		add.setZipcode(60142);
		
		emp.setAddress(add);
		
		return emp;
		
	} // end createEmployee()
	
	
	private static void writeToFile(String fileName, JsonObject empJSONObject) throws IOException {
		
		// create the writer
		OutputStream os = new FileOutputStream("emp.json");
		JsonWriter jsonWriter = Json.createWriter(os);
		
		// write the JSON object
		jsonWriter.writeObject(empJSONObject);
		jsonWriter.close();
		
	} // end writeToFile()
	
} // end EmployeeJSONWriter class


