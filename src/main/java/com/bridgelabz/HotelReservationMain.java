package com.bridgelabz;

import java.util.HashMap;
import java.util.Map;
/**
 * This is a main class.
 * In this we are adding and displaying the hotel details.
 * @author Tom
 *
 */
public class HotelReservationMain {
	public static void main(String[] args) {
		System.out.println("Welcome to Hotel Reservation System");
		HotelReservation hotelServices = new HotelReservation();
		hotelServices.addHotel("Lakewood", 3, 110, 90);
		hotelServices.addHotel("Bridgewood", 4, 16, 60);
		hotelServices.addHotel("Ridgewood", 5, 220, 150);
		
		hotelServices.displayHotel();
	 }
}
