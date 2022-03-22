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
 * 
 * @author Tom
 *
 */
public class HotelReservation {
	
	public ArrayList<Hotel> hotelList = new ArrayList<Hotel>();
	public Hotel hotel;
	public static double cheapestPrice;

	/**
	 * [1] Method to add the hotel to arrayList
	 * @param hotelName - we will pass the hotel name
	 * @param rating -  ratings of hotel
	 * @param weekdayRegularCustomerCost - weekday rates for regular customer
	 * @param weekendRegularCustomerCost - weekend rates for regular customer
	 * @param weekdayRewardCustomerCost - weekday rates for reward customer
	 * @param weekendRewardCustomerCost -  weekend rated for reward customers
	 */
	public void addHotel(String hotelName, int rating, double weekdayRegularCustomerCost,
			double weekendRegularCustomerCost, double weekdayRewardCustomerCost, double weekendRewardCustomerCost) {

		hotel = new Hotel();
		hotel.setHotelName(hotelName);
		hotel.setRating(rating);
		hotel.setWeekdayRegularCustomerCost(weekdayRegularCustomerCost);
		hotel.setWeekendRegularCustomerCost(weekendRegularCustomerCost);
		hotel.setWeekdayRewardCustomerCost(weekdayRewardCustomerCost);
		hotel.setWeekendRewardCustomerCost(weekendRewardCustomerCost);
		hotelList.add(hotel);
	}

	/**
	 * To get the numbers of hotels in list
	 * @return - size of array
	 */
	public int getHotelListSize() {
		return hotelList.size();
	}

	/**
	 * To print the hotel name
	 */
    public void printHotelList() {
		System.out.println(hotelList);
	}

    /**
     * To get the hotels in list
     * @return - list of hotels
     */
	public ArrayList<Hotel> getHotelList() {
		return hotelList;
	}

	/**
	 *  Method to get the duration of stay in hotel.
	 *  We are creating a list of total duration the person will stay.
	 *  Then we will calculate the weekdays and the weekends.
	 *  
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public ArrayList<Integer> getDurationOfStayDetails(LocalDate startDate, LocalDate endDate) {

		ArrayList<Integer> durationDetails = new ArrayList<Integer>();
		int numberOfDays = (int) ChronoUnit.DAYS.between(startDate, endDate) + 1;
		int weekends = 0;

		while (startDate.compareTo(endDate) != 0) {
			switch (DayOfWeek.of(startDate.get(ChronoField.DAY_OF_WEEK))) {
			case SATURDAY:
				++weekends;
				break;
			case SUNDAY:
				++weekends;
				break;
			default:
				break;
			}
			startDate = startDate.plusDays(1);
		}

		int weekdays = numberOfDays - weekends;
		durationDetails.add(weekdays);
		durationDetails.add(weekends);
		return durationDetails;

	}

	/**
	 * Method to compute the cheapest hotel
	 * @param startDate - will pass the entry date to hotel
	 * @param endDate - the exit date from hotel
	 * @return the cheapest hotel
	 */
	public ArrayList<Hotel> getCheapestHotel(LocalDate startDate, LocalDate endDate) {

		ArrayList<Integer> durationDetails = getDurationOfStayDetails(startDate, endDate);
		int weekdaysNumber = durationDetails.get(0);
		int weekendsNumber = durationDetails.get(1);

		cheapestPrice = hotelList.stream()
				.mapToDouble(hotel -> ((hotel.getWeekendRegularCustomerCost() * weekendsNumber)
						+ hotel.getWeekdayRegularCustomerCost() * weekdaysNumber))
				.min()
				.orElse(Double.MAX_VALUE);

		ArrayList<Hotel> cheapestHotel = hotelList.stream()
				.filter(hotel -> (hotel.getWeekendRegularCustomerCost() * weekendsNumber
						+ hotel.getWeekdayRegularCustomerCost() * weekdaysNumber) == cheapestPrice)
				.collect(Collectors.toCollection(ArrayList::new));

		if (cheapestPrice != Double.MAX_VALUE) {
			Iterator<Hotel> iterator = cheapestHotel.iterator();
			System.out.println("Cheap Hotels : \n");
			while (iterator.hasNext()) {
				System.out.println(iterator.next().getHotelName() + ", Total Rates: " + cheapestPrice);
			}
			return cheapestHotel;
		}
		return null;
	}

	/**
	 * Method to get the cheapest best rated hotel
	 */
	public Hotel getCheapestBestRatedHotel(LocalDate startDate, LocalDate endDate) {

		ArrayList<Hotel> cheapestHotels = getCheapestHotel(startDate, endDate);
		Optional<Hotel> sortedHotelList = cheapestHotels.stream()
				.max(Comparator.comparing(Hotel::getRating));

		System.out.println("Cheapest Best Rated Hotel : \n" + sortedHotelList.get().getHotelName() + ", Total Rates: "
				+ cheapestPrice);
		return sortedHotelList.get();
	}

	/**
	 * Method to get the best rated hotel from a given date range
	 */
	public Hotel getBestRatedHotel(LocalDate startDate, LocalDate endDate) {

		ArrayList<Integer> durationDetails = getDurationOfStayDetails(startDate, endDate);
		int weekdaysNumber = durationDetails.get(0);
		int weekendsNumber = durationDetails.get(1);

		Optional<Hotel> sortedHotelList = hotelList.stream()
				.max(Comparator.comparing(Hotel::getRating));

		double totalPrice = weekdaysNumber * sortedHotelList.get().getWeekdayRegularCustomerCost()
				+ weekendsNumber * sortedHotelList.get().getWeekendRegularCustomerCost();

		System.out.println("Best Rated Hotel : \n" + sortedHotelList.get().getHotelName() + ", Rating : "
				+ sortedHotelList.get().getRating() + ", Total Rates: " + totalPrice);
		return sortedHotelList.get();
	}

}