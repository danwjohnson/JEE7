package com.j2ee7.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMParsing {

	private List<Catalog> articles = new ArrayList<>();
	
	
	public List<Catalog> getListOfArticles() {
		
		return articles;
		
	} // end getListOfArticles()
	
	
	public void parseDocument() {
		
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File("article.xml"));
			doc.getDocumentElement().normalize();
			NodeList nodeList = doc.getElementsByTagName("article");
			
			for(int i = 0; i < nodeList.getLength(); i++) {
				
				Node node = nodeList.item(i);
				
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					
					Element element = (Element) node;
					Catalog c = new Catalog();
					
					c.setTitle(element.getElementsByTagName("title").item(0).getTextContent());
					c.setAuthor(element.getElementsByTagName("author").item(0).getTextContent());
					c.setPublishDate(element.getElementsByTagName("publish").item(0).getTextContent());
					c.setPublishDate(element.getElementsByTagName("link").item(0).getTextContent());
					articles.add(c);
					
				} // end if
				
			} // end for loop
			
		} // end try
		catch (Exception e) {
			
			e.printStackTrace();
			
		} // end catch
		
	} // end parseDocument
	
} // end DOMParsing
