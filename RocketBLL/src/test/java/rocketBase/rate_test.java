package rocketBase;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class rate_test {
	private static RateDomainModel modelRate;
	private static RateDomainModel badRate;
	private RateBLL bill;
	
	@BeforeClass
	public static void buildUpClass(){
		//bill = new RateBLL();
		modelRate = new RateDomainModel();
		modelRate.setiRateID(1);
		modelRate.setiMinCreditScore(600);
		modelRate.setdInterestRate(7);
		badRate = new RateDomainModel();
		badRate.setiRateID(-1);
		badRate.setiMinCreditScore(200);
		badRate.setdInterestRate(15);
	}
	
	//TODO - RocketBLL rate_test
	//		Check to see if a known credit score returns a known interest rate
	
	//TODO - RocketBLL rate_test
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score

	@Test
	public void rate_test() throws RateException{
		assertEquals(RateBLL.getRate(1000), 5.5, .01);
	}
	
	@Test(expected = RateException.class)
	public void rate_test2() throws RateException{
		RateBLL.getRate(200);
	}
	
	@Test
	public void getPaidTest(){
		//getPayment(double r, double n, double p, double f, boolean t)
		//assertEquals(RateBLL.getPayment(5, 165000, 30*12, 165000, true), 885.76, .01);
		RateBLL.getPayment(4, 360, 300000, 0, true);
	}
	
	

}
