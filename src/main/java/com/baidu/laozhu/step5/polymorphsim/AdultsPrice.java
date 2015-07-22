package com.baidu.laozhu.step5.polymorphsim;

public class AdultsPrice extends Price {
	int getPriceCode() {
		return Movie.ADULTS;
	}

	double getCharge(int daysRented) {
		double thisAmount = 5;
		if (daysRented > 1) {
			thisAmount += (daysRented - 1) * 3;
		}
		return thisAmount;
	}

}
