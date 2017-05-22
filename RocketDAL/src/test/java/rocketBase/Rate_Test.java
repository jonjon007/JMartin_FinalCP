package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import rocketDomain.RateDomainModel;

public class Rate_Test {
	private static RateDomainModel modelRate;
	@BeforeClass
	public static void buildUpClass(){
		modelRate = new RateDomainModel();
		modelRate.setiRateID(1);
		modelRate.setiMinCreditScore(600);
		modelRate.setdInterestRate(7);
	}
	
	@Before
	public void buildUp(){
	
	}
	
	@After
	public void tearDown(){
	
	}
	
	@AfterClass
	public static void tearDownClass(){
	
	}
	
	@Test
	public void order_test(){
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		for(int i = 0; i < rates.size() - 1; i++){
			assertTrue(rates.get(i).getiMinCreditScore() <= rates.get(i+1).getiMinCreditScore());
		}
	}
	

}
