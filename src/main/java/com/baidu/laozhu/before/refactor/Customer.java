package com.baidu.laozhu.before.refactor;

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
			double thisAmount = 0;
			switch (aRental.getMovie().getPriceCode()) {
			case Movie.CHILDRENS:
				thisAmount += 2;
				if (aRental.getDaysRented() > 2) {
					thisAmount += (aRental.getDaysRented() - 2) * 1.5;
				}
				break;
			case Movie.NEW_RELEASE:
				thisAmount += aRental.getDaysRented() * 3;
				break;
			case Movie.ADULTS:
				thisAmount += 5;
				if (aRental.getDaysRented() > 1) {
					thisAmount += (aRental.getDaysRented() - 1) * 3;
				}
				break;
			default:
				break;
			}
			frequentRenterPoints++;
			if (aRental.getMovie().getPriceCode() == Movie.NEW_RELEASE
					&& aRental.getDaysRented() > 1) {
				frequentRenterPoints++;
			}
			result += "\t" + aRental.getMovie().getTitle() + "\t"
					+ String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;
		}
		result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ " frequent renter points";
		return result;
	}
}
