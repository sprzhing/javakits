package com.baidu.laozhu.step4.replaceconditionwithpolymorthism;

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
		String result = "Rental Record for" + getName() + "\n";
		for (Rental aRental : rentals) {
			result += "\t" + aRental.getMovie().getTitle() + "\t"
					+ String.valueOf(aRental.getCharge()) + "\n";
		}
		result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
		result += "You earned "
				+ String.valueOf(getTotalFrequentRenterPoints())
				+ " frequent renter points";
		return result;
	}
	private double getTotalAmount() {
		double amount = 0;
		for (Rental aRental : rentals) {
			amount += aRental.getCharge();
		}
		return amount;
	}

	private int getTotalFrequentRenterPoints() {
		int frequentRenterPoints = 0;
		for (Rental aRental : rentals) {
			frequentRenterPoints += aRental.getFrequentRenterPoints();
		}
		return frequentRenterPoints;
	}

	public String htmlStatement() {
		String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
		for (Rental aRental : rentals) {
			result += aRental.getMovie().getTitle() + ":"
					+ String.valueOf(aRental.getCharge()) + "<BR>\n";
		}
		result += "<P>You owe <EM> " + String.valueOf(getTotalAmount())
				+ "</EM><P>\n";
		result += "On this rental you earned <EM>"
				+ String.valueOf(getTotalFrequentRenterPoints())
				+ "<EM>frequent renter points<P>";
		return result;
	}
}
