package kodutöö;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;


class Response {
	private Item[] rows;
	public Item[] getRows() {
		return rows;
	}
	public void setRows(Item[] rows) {
		this.rows=rows;
	}
}
class Item {
	private Element[] elements;
	public Element[] getElements() {
		return elements;
	}
	public void setElements(Element[] elements) {
		this.elements=elements;
	}
}
class Element {
	Distance distance;
}

public class DistanceCalculator {
	
		
	
	public static void main(String[] args) throws JsonSyntaxException, Exception {
		Response r = (new Gson().fromJson(urlReader("https://maps.googleapis.com/maps/api/distancematrix/json?origins=Tallinn&destinations=Tartu&key=AIzaSyD20ffjfCx1umPzjLSsmhD9KKfS-SHi1Dg"), Response.class));
	    System.out.println(r);
	    
	}
	private static String urlReader(String urlString) throws Exception {
		BufferedReader br = null;
		try {
			URL url = new URL(urlString);
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			int read;
			char[] array = new char[1024];
			while((read = br.read(array)) != -1)
				buffer.append(array, 0, read);
			return buffer.toString();
		} finally {
			if (br != null)
				br.close();	
		}
	}
}

