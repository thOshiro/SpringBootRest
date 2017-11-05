package service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service
public class FinanceCalculatorService implements IFinanceCalculatorService{
	

	@Override
	public HashMap<Integer, Double> calculateCompoundInterestMonthly(double baseAmount, double interestRate,
			int periodInMonths,
			double montlhyInvestment) {
		
		HashMap<Integer, Double> montlhyResult = new HashMap<>(); 
		double result = 0;
		
		for(int i=0; i<periodInMonths ;i++) {
			result += calculateCompoundInterest(baseAmount, interestRate, i+1) + montlhyInvestment;
			result = new BigDecimal(result, MathContext.DECIMAL64).setScale(2, RoundingMode.CEILING).doubleValue();
			montlhyResult.put(i, result);
		}

		return montlhyResult;
	}
	
	@Override
	public Double calculateCompoundInterest(double baseAmount, double interestRate, int periodInMonths) {
		return baseAmount * Math.pow(1 + interestRate/100, periodInMonths);
	}
}
