package kodutöö;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.InputStreamReader;

public class URLfetch {
	public static String URLget() throws IOException {
		String str = null;
		String adre = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=Tallinn&destinations=Tartu&key=AIzaSyD20ffjfCx1umPzjLSsmhD9KKfS-SHi1Dg";
		URL url = null;
		try {
			url = new URL(adre);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		HttpsURLConnection p2ring = (HttpsURLConnection) url.openConnection();
		try {
			p2ring.connect();
		} catch (IOException e) {
			e.printStackTrace();
		}

		JsonParser jas = new JsonParser();
		JsonElement root = jas.parse(new InputStreamReader((InputStream) p2ring.getContent()));
		JsonObject mainObject = root.getAsJsonObject();
		str = mainObject.get("distance").getAsString();

		return str;
	}
}
