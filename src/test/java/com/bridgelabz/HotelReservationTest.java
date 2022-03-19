package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

/**
 * In this we are creating the test cases. If the hotel is added it will return true.
 * @author Tom
 *
 */
public class HotelReservationTest {
	@Test
	public void givenHotelDetails_addHotel() {
		HotelReservation hotelService = new HotelReservation();
		
		boolean isValidHotel1 = hotelService.addHotel("Lakewood", 3, 110, 90);
		Assert.assertTrue(isValidHotel1);
		
		boolean isValidHotel2 = hotelService.addHotel("Bridgewood", 4, 16, 60);
		Assert.assertTrue(isValidHotel2);
		
		boolean isValidHotel3 = hotelService.addHotel("Ridgewood", 5, 220, 150);
		Assert.assertTrue(isValidHotel3);
	}

}
