package com.bridgelabz;

import java.time.*;
import java.time.temporal.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * We have created this class to add the services of the hotel
 * [1] In this method we will add the hotel to the ArrayList
 * [2] To display the hotel name and the details
 * @author Tom
 *
 */
public class HotelReservation {
	
	ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
	public static double cheapestPrice;
     
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
	 * Then we are comparing the regular cost of the hotel and finding the cheapest hotel
	 * We are using the min method to get the list of minimum cost.
	 * @param startDate - in this we will pass the entry date to hotel
	 * @param endDate - in this we will pass the exit date from hotel
	 * @return -  we will return the hotel with cheapest rate
	 */
	public ArrayList<Hotel> getCheapestHotel(LocalDate startDate, LocalDate endDate) {

		int numberOfDays = (int) ChronoUnit.DAYS.between(startDate, endDate)+1;
        int weekends = 0;
        
		while (startDate.compareTo(endDate) != 0) {
            switch (DayOfWeek.of(startDate.get(ChronoField.DAY_OF_WEEK))) {
                case SATURDAY:
                    ++weekends;
                    break;
                case SUNDAY:
                    ++weekends;
                    break;
            }
            startDate = startDate.plusDays(1);
        }
		
		final int weekdaysNumber = numberOfDays - weekends;
		final int weekendsNumber = weekends;
		
		cheapestPrice = hotelList.stream()
				.mapToDouble(hotel -> ((hotel.getWeekendRegularCustomerCost()*weekendsNumber) + hotel.getWeekdayRegularCustomerCost()*weekdaysNumber))
				.min()
				.orElse(Double.MAX_VALUE);
		
		ArrayList<Hotel> cheapestHotel = hotelList.stream()
				.filter(hotel -> (hotel.getWeekendRegularCustomerCost()*weekendsNumber + hotel.getWeekdayRegularCustomerCost()*weekdaysNumber) == cheapestPrice)
				.collect(Collectors.toCollection(ArrayList::new));
		
        if (cheapestPrice != Double.MAX_VALUE) {
        	Iterator<Hotel> iterator = cheapestHotel.iterator();
        	while(iterator.hasNext()) {
        		System.out.println("Cheap Hotel : \n" + iterator.next().getHotelName() + ", Total Rates: " + cheapestPrice);
        	}
        	return cheapestHotel;
        }
        return null;
	}
	
	public Hotel getCheapestBestRatedHotel(LocalDate startDate, LocalDate endDate){
		
		ArrayList<Hotel> cheapestHotels = getCheapestHotel(startDate, endDate);
		Optional<Hotel> sortedHotelList = cheapestHotels.stream().max(Comparator.comparing(Hotel::getRating));
		System.out.println("Cheapest Best Rated Hotel : \n" + sortedHotelList.get().getHotelName() + ", Total Rates: " + cheapestPrice);
		return sortedHotelList.get();
	}

}

