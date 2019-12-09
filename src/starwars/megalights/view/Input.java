package starwars.megalights.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * @author Jordi Borrell
 *
 */
public class Input {

	/**
	 * @return The number of megalights of the distance we want cover.
	 */
	public BigInteger getNumberMegaLights() {
		
		BigInteger numberMGLT = null;
		 while( numberMGLT ==  null) {
			 System.out.println("Introduce the distance in mega lights: ");
			 java.io.BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			 try {
				 numberMGLT = new BigInteger(in.readLine());	 
			 }catch(Exception e) { 
				 numberMGLT= null; 
			 }
		 }
		 return numberMGLT;
	}
}
