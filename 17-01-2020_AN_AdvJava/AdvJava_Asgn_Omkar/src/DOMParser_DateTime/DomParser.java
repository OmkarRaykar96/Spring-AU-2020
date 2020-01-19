package DOMParser_DateTime;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

public class DomParser {
public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder = factory.newDocumentBuilder();
	
	Document document = builder.parse(new File("Persons.xml"));
	document.getDocumentElement().normalize();
	
	Element root = document.getDocumentElement();
	System.out.println(root.getNodeName());
	
	NodeList nList = document.getElementsByTagName("person");	 
	
	for (int temp = 0; temp < 10; temp++)// For complete document -> nList.getLength()
	{
	 Node node = nList.item(temp);
	 if (node.getNodeType() == Node.ELEMENT_NODE)
	 {
		
	    Element eElement = (Element) node;
	    System.out.println("\nPerson ID : "  + eElement.getElementsByTagName("PersonID").item(0).getTextContent());
	    System.out.println("Name : "   + eElement.getElementsByTagName("FullName").item(0).getTextContent());
	    System.out.println("City : "    + eElement.getElementsByTagName("CityofResidence").item(0).getTextContent());
	    System.out.println("Contact : "    + eElement.getElementsByTagName("ContactNumber").item(0).getTextContent());
	    System.out.println("Income : "    + eElement.getElementsByTagName("SalaryEarned").item(0).getTextContent());
	    System.out.println("Location Coordinates : "    + eElement.getElementsByTagName("ResidentialCoordinates").item(0).getTextContent());
	    System.out.println("Nationality : "    + eElement.getElementsByTagName("Nationality").item(0).getTextContent());
	    System.out.println("Region : "    + eElement.getElementsByTagName("RegionofResidency").item(0).getTextContent());
	    System.out.println("PinCode : "    + eElement.getElementsByTagName("PinCodeNumber").item(0).getTextContent());
	    System.out.println("Organization Number : "    + eElement.getElementsByTagName("OrganizationNumber").item(0).getTextContent());
	    System.out.println("Personal Number : "    + eElement.getElementsByTagName("PersonalNumber").item(0).getTextContent());
	    System.out.println("Company : "    + eElement.getElementsByTagName("CompanyName").item(0).getTextContent());
	    System.out.println("EmailID : "    + eElement.getElementsByTagName("EmailID").item(0).getTextContent());
	    System.out.println("CVVNumber : "    + eElement.getElementsByTagName("CVVNumber").item(0).getTextContent());
	    System.out.println("---------------------------------------------");
	 }
	 System.out.println();
	}
}
}