package com.ex.fileio.obj.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ex.fileio.obj.BankAccount;

/*
 * javax.xml
 * org.w3c.dom
 * 
 * After example, create xml file with single account object and read it
 */
public class BankAccountDOMIO {
	public static void main(String[] args) {
		
		String filename = "src/com/ex/fileio/obj/xml/bankAccounts.xml";
		
//		writeBankAccounts(filename);
		readBankAccounts(filename);
	}

	static void writeBankAccounts(String filename) {
		
		BankAccount john   = new BankAccount(1, "John",   120.50);
		BankAccount amy    = new BankAccount(2, "Amy",    2000);
		BankAccount austin = new BankAccount(3, "Austin", 460.70);
		
		List<BankAccount> accounts = new ArrayList<>();
		accounts.add(john);
		accounts.add(amy);
		accounts.add(austin);
		
		
		try {

			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder;

			docBuilder = docFactory.newDocumentBuilder();
			
			Document doc = docBuilder.newDocument();
			
			Element root = doc.createElement("accounts");
			doc.appendChild(root);
			
			for(BankAccount temp : accounts){
				Element account = doc.createElement("account");
				root.appendChild(account);
				
				Element bankAccountNumber  = doc.createElement("bankAccountNumber");
						bankAccountNumber.appendChild(doc.createTextNode("" + temp.getBankAccountNumber()));
				Element customerName 	   = doc.createElement("customerName");
						customerName.appendChild(doc.createTextNode(temp.getCustomerName()));
				Element balance 		   = doc.createElement("balance");
						balance.appendChild(doc.createTextNode("" + temp.getBalance()));

				account.appendChild(bankAccountNumber);
				account.appendChild(customerName);
				account.appendChild(balance);
				
			}
//			printXML(doc); //test to see if document contains correct data
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t = tf.newTransformer();
			t.setOutputProperty(OutputKeys.INDENT, "yes");
			t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filename));
			
			t.transform(source, result);
			
		
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	static void printXML(Document doc){
		
		Element root = doc.getDocumentElement();
		
		System.out.println(root.getNodeName()); //print root
		
		NodeList nList = root.getChildNodes();
		for(int i = 0; i < nList.getLength(); i++){
			Node account = nList.item(i);
			System.out.println("\t" + account.getNodeName());
			
			NodeList accountChildren = account.getChildNodes();
			
			for(int j = 0; j < accountChildren.getLength(); j++){
				
				Node accountChild = accountChildren.item(j);
				System.out.println("\t\t" + accountChild.getNodeName() + " : " + accountChild.getTextContent());
				
			}
		}
	}

	static void readBankAccounts(String filename) {
		
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(filename);
			
			doc.getDocumentElement().normalize();
			
			System.out.println(doc.getDocumentElement().getNodeName());
			
			NodeList accountList = doc.getElementsByTagName("account");
			
			for(int i = 0; i < accountList.getLength(); i++){
				Node account = accountList.item(i);
				System.out.println("\t" + account.getNodeName());
				
				NodeList accountChildren = account.getChildNodes();
				for(int j = 0; j < accountChildren.getLength(); j++){
					Node child = accountChildren.item(j);
					if(child.getNodeType() == Node.ELEMENT_NODE) {
						System.out.println("\t\t" + child.getNodeName() + " : " + child.getTextContent());
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
