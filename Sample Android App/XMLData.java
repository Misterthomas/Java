package weather.application.daraszewicz;

public class XMLData {
	int temp =0;
	String city = null;
	String humidity = null;
	String condition = null;
	String wind = null;
	
	
	public XMLData(){}
	
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getWind() {
		return wind;
	}
	public void setWind(String wind) {
		this.wind = wind;
	}
	public String getTemp() {
		return "" +temp+ "C";
	}
	public String getCity() {
		return city;
	}
	public void setCity(String City){
		city = City;
	}
	public void  setTemp (int t){
		temp = t;
	}
	public void sethumidity(String h){
		humidity = h;
	}
	
	public void setcondition(String c){
		condition = c;
	}
	
	public void setwind(String w){
		wind = w;
	}
	
}

