package com.pc.saxparsing;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class SAXXMLHandler extends DefaultHandler {
	 private List<ScoreInfo> scoreinfo;
   private String tempVal;
   private ScoreInfo tempInfo;
   private BattingInfo batTempInfo;
   public SAXXMLHandler() {
  	 scoreinfo = new ArrayList<ScoreInfo>();
 }

 public List<ScoreInfo> getInfo() {
     return scoreinfo;
 }
 @Override
public void startElement (String uri, String localName, String qName, Attributes attributes) throws SAXException {
	super.startElement(uri, localName, qName, attributes);
	tempVal ="";
	if (qName.equalsIgnoreCase("status")) {
    // create a new instance of employee
    tempInfo = new ScoreInfo();
} //else if(qName.equalsIgnoreCase("batting_team_info")){
//batTempInfo = new BattingInfo();
//}
	
}
 @Override
public void endElement (String uri, String localName, String qName) throws SAXException {
	if(qName.equalsIgnoreCase("status")){
		scoreinfo.add(tempInfo);		
	}else if(qName.equalsIgnoreCase("start_date")){
	tempInfo.setStart_date(tempVal);	
	System.out.println("");
	}else if(qName.equalsIgnoreCase("start_time")){
		tempInfo.setStart_time(tempVal);
	}else if(qName.equalsIgnoreCase("end_time")){
		tempInfo.setEnd_time(tempVal);
	}else if(qName.equalsIgnoreCase("match_type")){
		tempInfo.setMatch_type(tempVal);
	}else if(qName.equalsIgnoreCase("current_status")){
		tempInfo.setCurrent_status(tempVal);
	}
	}/*else if(qName.equalsIgnoreCase("livescore")){
		if(qName.equalsIgnoreCase("batting_team_info")){
			
		}
	}else if(){
		
	}*/

 @Override
public void characters (char[] ch, int start, int length) throws SAXException {
	 tempVal = tempVal+ new String(ch, start, length);
}
 
}
