package service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class FinanceCalculator {
	
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
	public Map<Integer, Double> calculateCompoundInterestMonthly(double baseAmount, double interestRate,
			int periodInMonths,
			double montlhyInvestment) {
		
		Map<Integer, Double> montlhyResult = new HashMap<>(); 
		double result = 0;
		
		for(int i=0; i<periodInMonths ;i++) {
			result += calculateCompoundInterest(baseAmount, interestRate, i+1) + montlhyInvestment;
			result = new BigDecimal(result, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING).doubleValue();
			montlhyResult.put(i, result);
		}

		return montlhyResult;
	}
	
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
	private Double calculateCompoundInterest(double baseAmount, double interestRate, int periodInMonths) {
		return baseAmount * Math.pow(1 + interestRate/100, periodInMonths);
	}
}
