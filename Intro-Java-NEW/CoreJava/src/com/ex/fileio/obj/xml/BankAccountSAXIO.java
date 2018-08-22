package com.ex.fileio.obj.xml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

/*
 * javax.xml
 * org.xml.sax
 */
public class BankAccountSAXIO {
	public static void main(String[] args) {
		
		String filename = "src/com/ex/fileio/obj/xml/bankAccounts.xml";
		
		readBankAccounts(filename);
	}
	
	static void readBankAccounts(String filename){
		
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			BankAccountHandler handler = new BankAccountHandler();
			saxParser.parse(filename, handler);
			
			
		} catch (ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
}
