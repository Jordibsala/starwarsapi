package starwars.megalights.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

/**
 * @author Jordi Borrell
 *
 */
public class DataProvider {

  private String API_URL= "https://swapi.co/api/starships/?format=json";
  
  /**
 * @param rd BufferedReader
 * @return JSON String with data of API call
 * @throws IOException
 */
private String readAll(BufferedReader rd) throws IOException {
	StringBuilder sb = new StringBuilder();
    String line = null;
    while ((line = rd.readLine()) != null) {
        sb.append(line + "\n");
    }
    return sb.toString();
  }

  /**
 * @param url (URL of SWAPI)
 * @return JSON Object
 * @throws IOException
 * @throws JSONException
 */
private JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = this.readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      is.close();
    }
  }
	
   /**
 * @param arr1 JSONArrays
 * @param arr2 JSONArrays
 * @return concatenate to JSONArrays 
 * @throws JSONException
 */
private JSONArray concatArray(JSONArray arr1, JSONArray arr2) throws JSONException {
	    JSONArray result = new JSONArray();
	    for (int i = 0; i < arr1.length(); i++) {
	        result.put(arr1.get(i));
	    }
	    for (int i = 0; i < arr2.length(); i++) {
	        result.put(arr2.get(i));
	    }
	    return result;
	}
		  
	/**
	 * @return A list of JSONObjects of starships
	 */
	public JSONArray getStarships (){

		System.out.println("Getting information from system...");
		JSONArray starships = null;
		try {
			JSONObject json = this.readJsonFromUrl(API_URL);
		    starships = new JSONArray(json.get("results").toString());
		    
		    while(json.get("next").toString() != "null") {
			    json = this.readJsonFromUrl(json.get("next").toString());
			    JSONArray results = new JSONArray(json.get("results").toString());
			    
			    starships = this.concatArray(starships, results);
		    }
		}catch(Exception e) {
			System.out.println("We found some problems retrieving the data. :(");
		}
	    
	    return starships;
	}
}
