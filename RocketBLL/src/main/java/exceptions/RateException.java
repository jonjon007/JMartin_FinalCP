package exceptions;

import rocketBase.RateBLL;
import rocketDomain.RateDomainModel;

public class RateException extends Exception {
	private RateDomainModel r;
	
	public RateException(RateDomainModel rte){
		super();
		r = rte;
	}
	
	
	public RateDomainModel getRateDomainModel(){
		return r;
	}
	//	TODO - RocketBLL RateException - RateDomainModel should be an attribute of RateException
	//	* Add RateRomainModel as an attribute
	//	* Create a constructor, passing in RateDomainModel
	//	* Create a getter (no setter, set value only in Constructor)
}
