package com.bridgelabz;

/**
 *  Class Hotel where we defined the variables
 * @author Tom
 *
 */
public class Hotel {
	String hotelName;
	int rating;
	double weekDayRegularCustomerCost;
	double weekendRegularCustomerCost;
	
	/**
	 *  Parameterized Constructor
	 *  Here we will pass the details of the regular customer
	 * 
	 */
	public Hotel(String hotelName, int rating, double weekDayRegularCustomerCost,double weekDayRewardCustomerCost, double weekendRegularCustomerCost, double weekendRewardCustomerCost) {
		super();
		this.hotelName = hotelName;
		this.rating = rating;
		this.weekDayRegularCustomerCost = weekDayRegularCustomerCost;
		this.weekendRegularCustomerCost = weekendRegularCustomerCost;
	}
	
	public Hotel(){
		
	}


	//getters and setters
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


	public double getWeekDayRegularCustomerCost() {
		return weekDayRegularCustomerCost;
	}


	public void setWeekDayRegularCustomerCost(double weekDayRegularCustomerCost) {
		this.weekDayRegularCustomerCost = weekDayRegularCustomerCost;
	}


	public double getWeekendRegularCustomerCost() {
		return weekendRegularCustomerCost;
	}


	public void setWeekendRegularCustomerCost(double weekendRegularCustomerCost) {
		this.weekendRegularCustomerCost = weekendRegularCustomerCost;
	}


	@Override
	public String toString() {
		return " \n Hotel [hotelName=" + hotelName + ", rating=" + rating + ", weekDayRegularCustomerCost="
				+ weekDayRegularCustomerCost + ", weekendRegularCustomerCost=" + weekendRegularCustomerCost + "]";
	}
	
	
  
}
