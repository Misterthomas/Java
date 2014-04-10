package weather.application.daraszewicz;

import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.graphics.Picture;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class WeatherXML extends Activity implements OnClickListener {
	TextView tv, show_city, show_temperature, show_wind, show_humidity, show_condition;
	EditText city, country;
	String wind_direction;


	static final String startURL = "http://www.google.co.uk/ig/api?weather=";

	ViewFlipper flippy;
	Button b1;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		flippy = (ViewFlipper) findViewById(R.id.viewFlipper1);
		flippy.setInAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_in));
		flippy.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));

		flippy.setOnClickListener(this);

		b1 = (Button)findViewById(R.id.submit);
		tv = (TextView) findViewById (R.id.current);
		city = (EditText) findViewById(R.id.editCity);
		
		
		show_city = (TextView) findViewById (R.id.show_city);
		show_temperature = (TextView) findViewById (R.id.show_temperature);
		show_wind = (TextView) findViewById (R.id.show_wind);
		show_humidity = (TextView) findViewById (R.id.show_humidity);
		show_condition = (TextView) findViewById (R.id.show_condition);

		b1.setOnClickListener(this);



	}


	public void onClick(View v) {
		// TODO Auto-generated method stub


		if(v == b1){
			
			

			String City = city.getText().toString();
			String W = "w";
			View arrow = findViewById(R.id.imageView1);
			StringBuilder URL = new StringBuilder(startURL);
			URL.append(City);
			String totalURL= URL.toString();
			try{
				
				
				URL website = new URL(totalURL);
				SAXParserFactory spf = SAXParserFactory.newInstance();
				SAXParser sp = spf.newSAXParser();
				XMLReader xr = sp.getXMLReader();

				XMLStuff working = new XMLStuff();
				xr.setContentHandler(working);
				xr.parse(new InputSource(website.openStream()));


				String temperature = working.getTemp();
				String city_value = working.getCity();
				String wind_value = working.removeJunk(working.getWind(), "Wind:");
				String condition_value = working.getCondition();
				String humidity_value = working.removeJunk(working.getHumidity(), "Humidity:");

				wind_direction = (wind_value.substring(0, 2)).trim();
				
				show_city.setText(city_value.toUpperCase());
				show_temperature.setText(temperature);
				show_wind.setText(wind_value);
				show_humidity.setText(humidity_value);
				show_condition.setText(condition_value);
				
				
				if (wind_direction.equals("E")){
					TranslateAnimation anim = new TranslateAnimation(0f, 400f, 0f, 0f);
					   anim.setDuration(10000);
					   anim.setRepeatCount(-1);
					   arrow.startAnimation(anim);
				}
				else if (wind_direction.equals(W)){
					 TranslateAnimation anim = new TranslateAnimation(400f, 0f, 0f, 0f);
						    anim.setDuration(10000);
						    anim.setRepeatCount(-1);
						   arrow.startAnimation(anim);
					
				}
				else if (wind_direction.equals("N")){
					TranslateAnimation anim = new TranslateAnimation(0f, 0f, 600f, 0f);
					    anim.setDuration(10000);
					   anim.setRepeatCount(-1);
					   arrow.startAnimation(anim);
					
				}
				else if (wind_direction.equals("S")){
					TranslateAnimation anim = new TranslateAnimation(0f, 0f, 0f, 600f);
					  anim.setDuration(10000);
					  anim.setRepeatCount(-1);
					   arrow.startAnimation(anim);
					
				}
				else if (wind_direction.equals("SE")){
					
					TranslateAnimation anim = new TranslateAnimation(0f, 400f, 0f, 600f);
					  anim.setDuration(10000);
					    anim.setRepeatCount(-1);
					   arrow.startAnimation(anim);
				}
				else if (wind_direction.equals("NW")){
					TranslateAnimation anim = new TranslateAnimation(400f, 0f, 600f, 0f);
					    anim.setDuration(10000);
						    anim.setRepeatCount(-1);
						    arrow.startAnimation(anim);
					
					
				}
				else if (wind_direction.equals("SW")){
					
					TranslateAnimation anim = new TranslateAnimation(400f, 0f, 0f, 600f);
								    anim.setDuration(10000);
								    anim.setRepeatCount(-1);
								    arrow.startAnimation(anim);
				}
				else if (wind_direction.equals("NE")){
					
					TranslateAnimation anim = new TranslateAnimation(0f, 400f, 600f, 0f);
									    anim.setDuration(10000);
										    anim.setRepeatCount(-1);
									    arrow.startAnimation(anim);
				}
				
				// no exception override text
				tv.setText("");


			}catch (Exception e){
				if (City == null || City.trim().equals("")){
					tv.setText("no city...");
				}
				else if( City.length() > 0){
					tv.setText("incorrect city...");
				}
				else{
					tv.setText("error");
				}
			}
		}


		else if(v == flippy){

			flippy.showNext();



		}


	}


}