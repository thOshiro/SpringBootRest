package service;

import java.util.HashMap;

public interface IFinanceCalculatorService {
	
	/**
	 *  Returns each month compound interest, since working with type double the result
	 *  will NOT be exact there for only an approximation of the result. Although the higher 
	 *  period the greater the error.
	 *   
	 *  @param baseAmount initial value
	 *  @param interestRate interest rate per month
	 *  @param periodInMonths period in month which the value will be kept
	 *  @param montlhyInvestment investment made per month
	 *  	
	 *  @return each month interest gained
	 */
	public HashMap<Integer, Double> calculateCompoundInterestMonthly(double baseAmount, double interestRate, int periodInMonths, double montlhyInvestment);
	
	/**
	 *  Returns the compound interest, since working with type double the result
	 *  will NOT be exact there for only an approximation of the result. Although the higher 
	 *  period the greater the error.
	 *   
	 *  @param baseAmount initial value
	 *  @param interestRate interest rate per month
	 *  @param periodInMonths period in month which the value will be kept
	 *  	
	 *  @return compound interest at the end of the period
	 */
	public Double calculateCompoundInterest(double baseAmount, double interestRate, int periodInMonths);

}
