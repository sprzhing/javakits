package com.baidu.laozhu.step4.replaceconditionwithpolymorthism;

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int ADULTS = 0;
	public static final int NEW_RELEASE = 1;
	private String title;
	private int priceCode;

	public Movie(String title, int priceCode) {
		this.title = title;
		this.priceCode = priceCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPriceCode() {
		return priceCode;
	}

	public void setPriceCode(int priceCode) {
		this.priceCode = priceCode;
	}

	public double getCharge(int daysRented) {
		double thisAmount = 0;
		switch (priceCode) {
		case Movie.CHILDRENS:
			thisAmount += 2;
			if (daysRented > 2) {
				thisAmount += (daysRented - 2) * 1.5;
			}
			break;
		case Movie.NEW_RELEASE:
			thisAmount += daysRented * 3;
			break;
		case Movie.ADULTS:
			thisAmount += 5;
			if (daysRented > 1) {
				thisAmount += (daysRented - 1) * 3;
			}
			break;
		default:
			break;
		}
		return thisAmount;
	}

	public int getFrequentRenterPoints(int daysRented) {
		if (priceCode == Movie.NEW_RELEASE && daysRented > 1) {
			return 2;
		} else {
			return 1;
		}
	}

}
