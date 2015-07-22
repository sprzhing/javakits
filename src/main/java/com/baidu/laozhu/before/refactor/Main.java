package com.baidu.laozhu.before.refactor;

public class Main {
	public static void main(String[] argv) {
		Customer customer = new Customer("王尼玛");
		customer.addRental(new Rental(new Movie("葫芦娃", 2), 3));
		customer.addRental(new Rental(new Movie("色戒", 0), 5));
		customer.addRental(new Rental(new Movie("匆匆那年", 1), 2));
		System.out.println(customer.statement());
	}
}
