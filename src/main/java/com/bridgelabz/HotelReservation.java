package com.bridgelabz;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.Scanner;

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
	
	public void addHotel(String hotelName, int rating, double weekdayRegularCustomerCost, double weekendRegularCustomerCost) {
		Hotel hotel = new Hotel();
			hotel.setHotelName(hotelName);
			hotel.setRating(rating);
			hotel.setWeekdayRegularCustomerCost(weekdayRegularCustomerCost);
			hotel.setWeekendRegularCustomerCost(weekendRegularCustomerCost);
			hotelList.add(hotel);
		}
	
	/**
	 * [2] To display the hotel name and the details
	 */
	public void displayHotel() {
		System.out.println(hotelList);
		
	}
	public int getHotelListSize() {
		return hotelList.size();
	}
	
	public void printHotelList() {
		System.out.println(hotelList);
	}
	
	public ArrayList<Hotel> getHotelList(){
		return hotelList;
	}
	
	/**
	 * Method to find the cheapest hotel. 
	 * In this we are using the ChromoUnit to get the date
	 * Then we are comparing the regular cost of the hotel and finding the cheapest hotel
	 * We are using the min method to get the list of minimum cost.
	 * @param startDate - in this we will pass the entry date to hotel
	 * @param endDate - in this we will pass the exit date from hotel
	 * @return -  we will return the hotel with cheapest rate
	 */
	public Hotel getCheapestHotel(LocalDate startDate, LocalDate endDate) {

		long numberOfDays = ChronoUnit.DAYS.between(startDate, endDate);
		Optional<Hotel> sortedHotelList = hotelList.stream().min(Comparator.comparing(Hotel::getWeekdayRegularCustomerCost));
		return sortedHotelList.get();
	}
}
