package com.bridgelabz;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Assert;
import org.junit.Test;

/**
 * In this we are creating the test cases. If the hotel is added it will return true.
 * @author Tom
 *
 */
public class HotelReservationTest {
	@Test
	public void givenHotelDetails_WhenValuesEnteredAreCorrect_ShoulReturnTrue()
	{
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 3, 110, 90);
		hotelReservation.addHotel("Bridgewood", 4, 150, 50);
		hotelReservation.addHotel("Ridgewood", 5, 220, 150);
		int hotelListSize = hotelReservation.getHotelListSize();
		hotelReservation.printHotelList();
		Assert.assertEquals(3, hotelListSize);
	}
	
	@Test
	public void givenHotelList_WhenAdded_shouldReturnProperHotelName(){
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Bridgewood", 4, 150, 50);
		String hotelName = hotelReservation.getHotelList().get(0).getHotelName();
		Assert.assertEquals("Bridgewood", hotelName);
	}
	
	@Test
	public void givenHotelList_WhenAdded_shouldReturnProperHotelRating(){
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Bridgewood", 4, 150, 50);
		int hotelRating = hotelReservation.getHotelList().get(0).getRating();
		Assert.assertEquals(4, hotelRating);
	}
	
	@Test
	public void givenHotelList_WhenAdded_shouldReturnProperHotelWeekdayRegularCustomerCost(){
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Bridgewood", 4, 150, 50);
		int hotelRegularCustomerCost = (int) hotelReservation.getHotelList().get(0).getWeekdayRegularCustomerCost();
		Assert.assertEquals(150, hotelRegularCustomerCost);
	}
	
	@Test
	public void givenHotelList_WhenAdded_shouldReturnProperHotelWeekendRegularCustomerCost(){
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Bridgewood", 4, 150, 50);
		int hotelRegularCustomerCost = (int) hotelReservation.getHotelList().get(0).getWeekendRegularCustomerCost();
		Assert.assertEquals(50, hotelRegularCustomerCost);
	}
	
	@Test
	public void givenHotelDetails_shouldReturnCheapestHotel(){
		
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 3, 110, 90);
		hotelReservation.addHotel("Bridgewood", 4, 160, 50);
		LocalDate startDate = LocalDate.of(2021, Month.SEPTEMBER, 10);    
		LocalDate endDate = LocalDate.of(2021, Month.SEPTEMBER, 12);    
		String hotelName = hotelReservation.getCheapestHotel(startDate, endDate);
		Assert.assertEquals("Lakewood", hotelName);
	}
}

