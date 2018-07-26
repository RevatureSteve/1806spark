package com.ex.fileio.obj.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BankAccountHandler extends DefaultHandler {
	
	/*
	 * What to do at start of xml element
	 * 
	 * use qName (qualified name)
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.print(qName + " : ");
	}

	/*
	 * What to do at end of xml element
	 * 
	 * use qName (qualified name)
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {}
	
	/*
	 * What to do at xml element's contents
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.print(new String(ch, start, length));
	}
	
	
	
	
}
