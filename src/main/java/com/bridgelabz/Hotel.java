package com.bridgelabz;

/**
 *  Class Hotel where we defined the variables
 * @author Tom
 *
 */
public class Hotel {
	private String hotelName;
	private int rating;
	private double weekdayRegularCustomerCost;
	private double weekendRegularCustomerCost;
	
	/**
	 *  Parameterized Constructor
	 *  Here we will pass the details of the regular customer
	 *  We are also passing the weekDay and weekend rates.
	 */
	public Hotel(String hotelName, int rating, double weekdayRegularCustomerCost, double weekendRegularCustomerCost) {
		this.hotelName = hotelName;
		this.rating = rating;
		this.weekdayRegularCustomerCost = weekdayRegularCustomerCost;
		this.weekendRegularCustomerCost = weekendRegularCustomerCost;
	}
	
	public Hotel() {
	}
	
	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public double getWeekdayRegularCustomerCost() {
		return weekdayRegularCustomerCost;
	}
	
	public void setWeekdayRegularCustomerCost(double weekdayRegularCustomerCost) {
		this.weekdayRegularCustomerCost = weekdayRegularCustomerCost;
	}
	
	public double getWeekendRegularCustomerCost() {
		return weekendRegularCustomerCost;
	}
	
	public void setWeekendRegularCustomerCost(double weekendRegularCustomerCost) {
		this.weekendRegularCustomerCost = weekendRegularCustomerCost;
	}

	@Override
	public String toString() {
		return " \n Hotel [hotelName=" + hotelName + ", rating=" + rating + ", weekdayRegularCustomerCost="
				+ weekdayRegularCustomerCost + ", weekendRegularCustomerCost=" + weekendRegularCustomerCost + "]";
	}
	
	

}