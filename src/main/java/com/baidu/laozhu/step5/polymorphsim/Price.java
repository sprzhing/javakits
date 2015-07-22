package com.baidu.laozhu.step5.polymorphsim;

public abstract class Price {
	abstract int getPriceCode();

	abstract double getCharge(int daysRented);

	int getFrequentRenterPoints(int daysRented) {
		return 1;
	}

	// public double getCharge(int daysRented) {
	// double thisAmount = 0;
	// switch (getPriceCode()) {
	// case Movie.CHILDRENS:
	// thisAmount += 2;
	// if (daysRented > 2) {
	// thisAmount += (daysRented - 2) * 1.5;
	// }
	// break;
	// case Movie.NEW_RELEASE:
	// thisAmount += daysRented * 3;
	// break;
	// case Movie.ADULTS:
	// thisAmount += 5;
	// if (daysRented > 1) {
	// thisAmount += (daysRented - 1) * 3;
	// }
	// break;
	// default:
	// break;
	// }
	// return thisAmount;
	// }
	//
	// public int getFrequentRenterPoints(int daysRented) {
	// if (getPriceCode() == Movie.NEW_RELEASE && daysRented > 1) {
	// return 2;
	// } else {
	// return 1;
	// }
	// }
}
