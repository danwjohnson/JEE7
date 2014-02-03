package com.j2ee7.xml;

import java.util.List;

public class ParseXML {

	public static void main(String args[]) {
		
		SAXParsing sax = new SAXParsing();
		sax.parseDocument();
		List<Catalog> list = sax.getListOfArticles();
		
		System.out.println("SAX XML Processing");
		for(Catalog c:list) {
			
			System.out.println(c.toString());
			
		} // end for loop to print information in xml file
		
		
		DOMParsing dom = new DOMParsing();
		dom.parseDocument();
		List<Catalog> listDom = sax.getListOfArticles();
		
		
		System.out.println("\nDOM XML Processing");
		for(Catalog c:listDom) {
			
			System.out.println(c.toString());
			
		} 
		
	} // end main
	
}
