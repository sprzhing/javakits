package com.baidu.laozhu.step2.movemethod;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String name;
	private List<Rental> rentals = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental rental) {
		this.rentals.add(rental);
	}

	public String getName() {
		return this.name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for" + getName() + "\n";
		for (Rental aRental : rentals) {
			// double thisAmount = aRental.getCharge(); 赋值后没有变化，可以去掉（Replace
			// temp with query)
			/*frequentRenterPoints++;
			if (aRental.getMovie().getPriceCode() == Movie.NEW_RELEASE
					&& aRental.getDaysRented() > 1) {
				frequentRenterPoints++;
			}*/
			frequentRenterPoints += aRental.getFrequentRenterPoints();
			result += "\t" + aRental.getMovie().getTitle() + "\t"
					+ String.valueOf(aRental.getCharge()) + "\n";
			totalAmount += aRental.getCharge();
		}
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;
	}
}
