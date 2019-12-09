package starwars.megalights.controller;
import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class CalculationsTest {

	@Test
	public void calculateDayHourstest() {
		Calculations calc = new Calculations();
		int result = calc.calculateHours("1 day");
		assertEquals(24, result);
	}
	@Test
	public void calculateDaysHourstest() {
		Calculations calc = new Calculations();
		int result = calc.calculateHours("2 days");
		assertEquals(48, result);
	}

	@Test
	public void calculateWeeksHourstest() {
		Calculations calc = new Calculations();
		int result = calc.calculateHours("2 weeks");
		assertEquals(7 * 24 * 2, result);
	}
	
	@Test
	public void calculateMonthsHourstest() {
		Calculations calc = new Calculations();
		int result = calc.calculateHours("3 months");
		assertEquals(30 * 24 * 3, result);
	}
	
	@Test
	public void calculateYearsMonthsHourstest() {
		Calculations calc = new Calculations();
		int result = calc.calculateHours("5 years");
		assertEquals(365 * 24 * 5, result);
	}
	
	@Test
	public void calculateHoursStoptest() {
		Calculations calc = new Calculations();
		int result = (int) calc.calculateHourStop(1000, new BigInteger("10"), new BigInteger("50000"));
		assertEquals(5, result);
	}
}
