package com.bridgelabz;

import java.util.HashMap;
import java.util.Map;

/**
 * We have created this class to add the services of the hotel
 * [1] In this method we will add the hotel to the HashMap
 * [2] To display the hotel name and the details
 * @author Tom
 *
 */
public class HotelReservation {
	
	Map<String, Hotel> hotelList = new HashMap<String, Hotel>();
     
	/**
	 * [1] In this method we will add the hotel to the HashMap
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
		
		hotelList.put(hotelName, hotels);
		return true;
	}
	
	/**
	 * [2] To display the hotel name and the details
	 */
	public void displayHotel() {
		for(String i : hotelList.keySet()) {
			System.out.println("The Hotel is : " + i + " \n The details of hotel is : " + hotelList.get(i));
		}
	}
}
