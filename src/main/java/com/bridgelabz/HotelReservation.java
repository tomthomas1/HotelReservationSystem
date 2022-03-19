package com.bridgelabz;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * We have created this class to add the services of the hotel
 * [1] In this method we will add the hotel to the ArrayList
 * [2] To display the hotel name and the details
 * @author Tom
 *
 */
public class HotelReservation {
	
	ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
     
	/**
	 * [1] In this method we will add the hotel to the ArrayList
	 * @param hotelName - we will pass the hotel name
	 * @param rating - we will pass the rating of the hotel
	 * @param weekDayRateRegular - We will pass the rate of week day for the regular customer
	 * @param weekendRateRegular -  we will pass the weekend rate for the regular customer
	 * @return
	 */
	public boolean addHotel(String hotelName,int rating, double weekDayRateRegular, double weekendRateRegular) {
		Hotel hotels = new Hotel();
		hotels.setHotelName(hotelName);
		hotels.setRating(rating);
		hotels.setWeekDayRegularCustomerCost(weekDayRateRegular);
		hotels.setWeekendRegularCustomerCost(weekendRateRegular);
		
		hotelList.add(hotels);
		return true;
	}
	
	/**
	 * [2] To display the hotel name and the details
	 */
	public void displayHotel() {
		System.out.println(hotelList);
		
	}
}
