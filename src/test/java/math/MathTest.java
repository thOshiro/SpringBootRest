package math;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import service.FinanceCalculatorService;

public class MathTest {
	
	
	FinanceCalculatorService calculator = new FinanceCalculatorService();
	
	
	@Test
	public void calculateCompoundInterestMonthly_test() {
		
		Double baseAmount = 100.00;
		Double interestRate = 0.5;
		int periodInMonths = 1;
		Double montlhyInvestment = 0.00;
		Map<Integer, Double> investResult;
		Double expectedResult = new Double("100.50");
		
		investResult = calculator.calculateCompoundInterestMonthly(baseAmount, interestRate, periodInMonths, montlhyInvestment);
		assertEquals(expectedResult, investResult.get(0));
	}
	
	@Test
	public void calculateCompoundInterestWithMontlhyInvest_test() {
		
		Double baseAmount = 100.00;
		Double interestRate = 0.5;
		int periodInMonths = 1;
		Double montlhyInvestment = 100.00;
		Map<Integer, Double> investResult;
		Double expectedResult = new Double("200.5");
		
		investResult = calculator.calculateCompoundInterestMonthly(baseAmount, interestRate, periodInMonths, montlhyInvestment);
		assertEquals(expectedResult, investResult.get(0));
	}
	
	@Test
	public void calculateCompoundInterestWithYearInvest_test() {
		
		Double baseAmount = 100.00;
		Double interestRate = 0.5;
		int periodInMonths = 2;
		Double montlhyInvestment = 100.00;
		Map<Integer, Double> investResult;
		List<Double> expectedResult = new ArrayList<Double>();
		expectedResult.add(new Double("200.5"));
		expectedResult.add(new Double("401.51"));
		
		investResult = calculator.calculateCompoundInterestMonthly(baseAmount, interestRate, periodInMonths, montlhyInvestment);
		
		for(int i=0; i<periodInMonths; i++) {
			assertEquals(expectedResult.get(i), investResult.get(i));
		}
	}


}
