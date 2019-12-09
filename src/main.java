import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import starwars.megalights.model.DataProvider;
import starwars.megalights.view.Input;
import starwars.megalights.view.Output;


/**
 * @author Jordi Borrell
 * 
 */
public class main {
	
	/**
	 * @param args (not used)
	 * {@summary} Print all stops for every starship according to the distance provided in MGLT 
	 */
	public static void main(String[] args) {
	    try {
	    	while(true) {
	    		BigInteger numMGLT= new Input().getNumberMegaLights();
	    		JSONArray starships = new DataProvider().getStarships();
	    		if(starships != null) {
	    			new Output().printStopsStarships(starships, numMGLT);
	    		}
	    		System.out.println("------------------------------");
	    	}
	    }catch(Exception e) {
	    	System.out.println("Upss, something is wrong. We can provide your results.");
	    }
    }
}
