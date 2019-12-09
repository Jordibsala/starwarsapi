package starwars.megalights.view;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigInteger;

import org.json.JSONArray;
import starwars.megalights.controller.Calculations;

/**
 * @author Jordi Borrell
 *
 */
public class Output {

	/**
	 * @param starships JSONArray
	 * @param numMGLT BigInteger (Total number of mega lights to calculate)
	 */
	public void printStopsStarships(JSONArray starships, BigInteger numMGLT) {
		
		for (int i = 0; i < starships.length(); i++) {
	        
			JSONObject starship = (JSONObject) starships.get(i);

	        if( !starship.get("MGLT").toString().contains("unknown")) {
	        	
	        	BigInteger starshipMGLT = new BigInteger(starship.get("MGLT").toString());
	        	int stops = (int) new Calculations().calculateStops(numMGLT, starshipMGLT, starship.get("consumables").toString());
	        	System.out.println( starship.get("name").toString() + ": " + stops);
	        
	        }
	    }
	}
}
