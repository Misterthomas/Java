package weather.application.daraszewicz;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLStuff extends DefaultHandler{
	
	private XMLData info = new XMLData();
	
	public String removeJunk(String string, String strToRemove)
	{   
	    return string.replaceAll(strToRemove, " ").trim();
	}
	
	public String getTemp(){
		return info.getTemp();
	}
	
	public String getCity(){
		return info.getCity();
	}
	
	public String getWind(){
		return info.getWind();
	}

	public String getHumidity() {
		return info.getHumidity();
	}
	public String getCondition() {
		return info.getCondition();
	}
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
	if (localName.equals("city")){
		String city = attributes.getValue("data");
		info.setCity(city);
	}
		else if (localName.equals("temp_c")){
			String t = attributes.getValue("data");
			int temp = Integer.parseInt(t);
			info.setTemp(temp);
			
	}
	
		else if (localName.equals("humidity")){
			String humidity = attributes.getValue("data");
			info.sethumidity(humidity);
			
		}
	
		else if (localName.equals("condition")){
			String condition = attributes.getValue("data");
			info.setcondition(condition);
	} 
	
		else if (localName.equals("wind_condition")){
			String wind = attributes.getValue("data");
			info.setwind(wind);
	} 
	

}
}
