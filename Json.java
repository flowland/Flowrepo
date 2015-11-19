package kodutöö;
import java.io.IOException;
import com.google.gson.Gson.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;

import javax.json.*;

public class Json {
	
		URL url = null;
		try {
			url = new URL("https://maps.googleapis.com/maps/api/distancematrix/json?origins=Tallinn&destinations=Tartu&key=AIzaSyD20ffjfCx1umPzjLSsmhD9KKfS-SHi1Dg");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			HttpURLConnection request = (HttpURLConnection) url.openConnection();
			JsonParser parser = new JsonParser();
			JsonElement all = parser.parse(new InputStreamReader((InputStream) request.getContent()));
			JsonObject jobject = all.getAsJsonObject();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	 public static ArrayList<String> readJsonFromUrl(String url) throws IOException, JSONException {
	        InputStream is = new URL(url).openStream();
	        try {
	            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	            String jsonText = readAll(rd);
	            JSONArray  json = new JSONArray(jsonText);

	            ArrayList<String> listdata = new ArrayList<String>();

	            if (json != null) {
	                for (int i=0;i<json.length();i++){
	                    listdata.add(json.get(i).toString());
	                }
	            }
	            return listdata;
	        } finally {
	            is.close();
	        }
	    }
	}