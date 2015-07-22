package com.baidu.laozhu.step5.polymorphsim;

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int ADULTS = 0;
	public static final int NEW_RELEASE = 1;
	private String title;
	// private int priceCode;
	private Price price;

	public Movie(String title, int priceCode) {
		this.title = title;
		// this.priceCode = priceCode;
		setPrice(priceCode);
	}

	public String getTitle() {
		return title;
	}

	private void setPrice(int priceCode) {
		switch (priceCode) {
		case CHILDRENS:
			price = new ChildrenPrice();
			break;
		case ADULTS:
			price = new AdultsPrice();
			break;
		case NEW_RELEASE:
			price = new NewReleasePrice();
			break;
		default:
			break;
		}
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getCharge(int daysRented) {
		return price.getCharge(daysRented);
	}

	public int getFrequentRenterPoints(int daysRented) {
		return price.getFrequentRenterPoints(daysRented);
	}

}
