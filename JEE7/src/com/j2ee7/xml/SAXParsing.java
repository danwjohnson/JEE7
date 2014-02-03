package com.j2ee7.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXParsing extends DefaultHandler{

	private List<Catalog> articles = new ArrayList<>();
	private boolean title = false;
	private boolean publish = false;
	private boolean author = false;
	private boolean link = false;
	private Catalog c;
	
	
	public List<Catalog> getListOfArticles() {
		
		return articles;
		
	} // end getListOfArticles()
	
	
	public void parseDocument() {
		
		try {
			
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(new File("article.xml"), this);
			
		} // end try
		catch (Exception e) {
			
			e.printStackTrace();
			
		} // end catch
		
	} // end parseDocument()
	
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		if (title) {
			
			c.setTitle(new String(ch, start, length));
			title = false;
			
		} // end if to check for title
		
		if (publish == true) {
			
			c.setPublishDate(new String(ch, start, length));
			publish = false;
			
		} // end if to check for publish date
		
		if (author == true) {
			
			c.setAuthor(new String(ch, start, length));
			author = false;
			
		} // end if to check for author
		
		if (link == true) {
			
			c.setLink(new String(ch, start, length));
			link = false;
			
		} // end if to check for link
		
	}  // end characters()
	
	
	public void startElement(String uri, String localName, 
			String qName, Attributes attributes) throws SAXException {
		
		if(qName.equalsIgnoreCase("article")) {
			
			c = new Catalog();
			articles.add(c);
			
		}
		
		if (qName.equalsIgnoreCase("title"))
			title = true;
		
		if (qName.equalsIgnoreCase("publish"))
			publish = true;
		
		if (qName.equalsIgnoreCase("author"))
			author = true;
		
		if (qName.equalsIgnoreCase("link"))
			link = true;
		
	} // end startElement()
	
	
	public void endElement(String ur, String localName,
			String qName) throws SAXException {
		
		
		
	} // end endElement()
	
} // end SAXParsing class
