package springboot.springController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import service.IFinanceCalculatorService;

@RestController
public class FinanceCalculatorController {

	@Autowired
	IFinanceCalculatorService financeCalculator;

	/**
	 * When entered the address compoundInterestMontly and the given parameters
	 * will result in a map with each period compound interest
	 * 
	 *  @param baseAmount initial value
	 *  @param interestRate interest rate per month
	 *  @param periodInMonths period in month which the value will be kept
	 *  @param montlhyInvestment investment made per month
	 *  	
	 *  @return each month interest gained
	 */
	
	@RequestMapping("/compoundInterestMontly")
	public Map<Integer, Double> calculateCompoundInterestMonthly(
			@RequestParam(value="baseAmount", defaultValue="0") double baseAmount,
			@RequestParam(value="interestRate", defaultValue="0")double interestRate,
			@RequestParam(value="monthPeriod", defaultValue="0") int periodInMonths,
			@RequestParam(value="monthlyInvestment", defaultValue="0") double monthlyInvestment) {
		return financeCalculator.calculateCompoundInterestMonthly(baseAmount, interestRate, periodInMonths, monthlyInvestment);
	}
}
