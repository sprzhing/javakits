package com.baidu.laozhu.step4.replaceconditionwithpolymorthism;

public class Rental {
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public int getDaysRented() {
		return daysRented;
	}

	public void setDaysRented(int daysRented) {
		this.daysRented = daysRented;
	}

	// 方法通常在它用到的数据类中
	public double getCharge() {
		// double thisAmount = 0;
		// switch (movie.getPriceCode()) {
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
		return movie.getCharge(daysRented);

	}

	public int getFrequentRenterPoints() {
		// if (movie.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1) {
		// return 2;
		// } else {
		// return 1;
		// }
		return movie.getFrequentRenterPoints(daysRented);
	}

}
