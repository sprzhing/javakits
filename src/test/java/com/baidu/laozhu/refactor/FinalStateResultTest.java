package com.baidu.laozhu.refactor;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.baidu.laozhu.step5.polymorphsim.Customer;
import com.baidu.laozhu.step5.polymorphsim.Movie;
import com.baidu.laozhu.step5.polymorphsim.Rental;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/applicationContext.summer.xml")
// 单元测试后事务回滚
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
public class FinalStateResultTest {
	@Test
	public void testAfterRefactorStatement() {
		Customer customer = new Customer("王尼玛");
		customer.addRental(new Rental(new Movie("葫芦娃", 2), 3));
		customer.addRental(new Rental(new Movie("色戒", 0), 5));
		customer.addRental(new Rental(new Movie("匆匆那年", 1), 2));
		System.out.println(customer.statement());
		Assert.assertTrue(customer
				.statement()
				.equals("Rental Record for王尼玛\n\t葫芦娃\t3.5\n\t色戒\t17.0\n\t匆匆那年\t6.0\nAmount owed is 26.5\nYou earned 4 frequent renter points"));
	}
}
