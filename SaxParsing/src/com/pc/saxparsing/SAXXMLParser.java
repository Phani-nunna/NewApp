package com.pc.saxparsing;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;


public class SAXXMLParser {
public static List<ScoreInfo> parse(InputStream is){
	
	List<ScoreInfo> info = null;
	try {
		XMLReader xmlReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
		SAXXMLHandler saxHandler = new SAXXMLHandler();
		xmlReader.setContentHandler(saxHandler);
		 xmlReader.parse(new InputSource(is));
		 info = saxHandler.getInfo();
		 System.out.println("info size"+info.size());
	}
	catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return info;
	
}
}
