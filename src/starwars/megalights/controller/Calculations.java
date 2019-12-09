package starwars.megalights.controller;

import java.math.BigInteger;

/**
 * @author Jordi Borrell
 *
 */
public class Calculations {

	private int dayHours = 24;
	private int weekDays = 7;
	private int monthDays = 30;
	private int yearDays = 365;
	
	/**
	 * @param starshipTime
	 * @return Total number of number of hours 
	 */
	public int calculateHours(String starshipTime) {
		
		String[] parts = starshipTime.split(" ");
		int timeValue =  Integer.parseInt(parts[0]);
		String timeUnits =  parts[1];

		switch(timeUnits) {
		
		case "day":
		case "days":
			return dayHours * timeValue;
		case "week":
		case "weeks":
			return dayHours * weekDays * timeValue;
		case "month":
		case "months":
			return dayHours * monthDays * timeValue;
		case "year":
		case "years":
			return dayHours * yearDays * timeValue;
		default: return 1;
			
		}
	}
	
	/**
	 * @param hours (int)
	 * @param starshipMGLT (BigInteger)
	 * @param numMGLT (BigInteger)
	 * @return number of stops according to hours of autonomy
	 */
	public double calculateHourStop(int hours, BigInteger starshipMGLT, BigInteger numMGLT) {
		int starshipMGLTAutonomy = starshipMGLT.intValue() * hours;
		return  Math.floor( numMGLT.intValue() / starshipMGLTAutonomy );
	}
	
	/**
	 * @param numMGLT (megalight total)
	 * @param starshipMGLT (starship megalights per hour)
	 * @param starshipTime (starship consumables)
	 * @return Total number of stops calculated for each starships
	 */
	public double calculateStops(BigInteger numMGLT,BigInteger starshipMGLT,String starshipTime) {
		
		int hours = this.calculateHours(starshipTime);
		return  this.calculateHourStop(hours, starshipMGLT, numMGLT);
	}
}
