package kodutöö;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Distance {
	
	static String str = DistanceCalculator.urlReader("https://maps.googleapis.com/maps/api/distancematrix/json?origins=Tallinn&destinations=Tartu&key=AIzaSyD20ffjfCx1umPzjLSsmhD9KKfS-SHi1Dg");
	
	public static void main(String[] args) {
		String str = DistanceCalculator.urlReader("https://maps.googleapis.com/maps/api/distancematrix/json?origins=Tallinn&destinations=Tartu&key=AIzaSyD20ffjfCx1umPzjLSsmhD9KKfS-SHi1Dg");
		try {
			JsonParser parse = new JsonParser();
			JsonObject json = (JsonObject)JsonParser.parse(str);
		}
	}
}
