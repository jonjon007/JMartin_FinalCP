package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.FinanceLib;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException 
	{
		double dInterestRate = 0;
		
		//TODO - RocketBLL RateBLL.getRate - make sure you throw any exception
		
		//		Call RateDAL.getAllRates... this returns an array of rates
		//		write the code that will search the rates to determine the 
		//		interest rate for the given credit score
		//		hints:  you have to sort the rates...  you can do this by using
		//			a comparator... or by using an OrderBy statement in the HQL
		if(GivenCreditScore < 600){
			RateDomainModel errorRate = new RateDomainModel();
			errorRate.setiMinCreditScore(GivenCreditScore);
			throw new RateException(errorRate);
		}
		//ArrayList<RateDomainModel> rateList = _RateDAL.getAllRates();
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		for(RateDomainModel rte : rates){
			if(rte.getdInterestRate() == 5.5 && GivenCreditScore >= 800
					|| rte.getdInterestRate() == 5.75 && GivenCreditScore >= 750
					|| rte.getdInterestRate() == 6 && GivenCreditScore >= 700
					|| rte.getdInterestRate() == 6.5 && GivenCreditScore >= 650
					|| rte.getdInterestRate() == 7 && GivenCreditScore >= 600){
				dInterestRate = rte.getdInterestRate();
				break;
			}
		}
			
		

		//TODO: Filter the ArrayList...  look for the correct rate for the given credit score.
		//	Easiest way is to apply a filter using a Lambda function.
		//
		//	Example... how to use Lambda functions:
		//			https://github.com/CISC181/Lambda
		
		return dInterestRate;
		
		
	}
	
	
	
	
	
	
	
	//TODO - RocketBLL RateBLL.getPayment 
	//		how to use:
	//		https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		System.out.println(FinanceLib.class.getName());
		return FinanceLib.pmt(r, n, p, f, t);
		//return FinanceLib.pmt(r, n, p, f, t);
		
	}
}
