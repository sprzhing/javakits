package com.baidu.laozhu.step5.polymorphsim;

public class ChildrenPrice extends Price {

	int getPriceCode() {
		return Movie.CHILDRENS;
	}
	double getCharge(int daysRented) {
		double thisAmount = 2;
		if (daysRented > 2) {
			 thisAmount += (daysRented - 2) * 1.5;
		}
		return thisAmount;
	}
}
