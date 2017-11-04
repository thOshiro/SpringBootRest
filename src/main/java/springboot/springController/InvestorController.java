package springboot.springController;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entity.Investor;
import service.FinanceCalculatorService;
import service.InvestorService;

@RestController
public class InvestorController {
	
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private InvestorService investorService;
	
	@Autowired
	private FinanceCalculatorService financeService;
	
	/**
	 * Register a new investor
	 * @param name investor name
	 * @param initialInvest investor initial value
	 * @param monthlyInvest investor monthly investment
	 * 
	 * @return The registered investor
	 */
	@RequestMapping("/registerInvestor")
	public Investor registerUser(@RequestParam(value="name", defaultValue="Stranger") String name,
			@RequestParam(value="initialInvest", defaultValue="0") Double initialInvest,
			@RequestParam(value="monthlyInvest", defaultValue="0") Double monthlyInvest) {
		
		Date accessDate = Calendar.getInstance().getTime();
		
		return investorService.addInvestor(counter.getAndIncrement(), name, accessDate, initialInvest, monthlyInvest);
	}
	
	
	/**
	 * List all investors and their attributes.
	 * 
	 * @return list of investors 
	 */
    @RequestMapping("/listInvestors")
    public List<Investor> getAllInvestors() {
		return investorService.findAllInvestors();
    }

    
    /**
     * Set an investor investment plan
     * @param investorId investor id
	 * @param interestRate investment interest rate
	 * @param months number of months the investment will last
	 * 
	 * @return the investor name as key, with the new investment plan prediction 
     * 
     */
    @RequestMapping("/setInvestorPlan")
    public Map<String, HashMap<Integer, Double>> getInvestorYearReturn(@RequestParam(value="investorId")long id, 
    		@RequestParam(value="interestRate") double interestRate, 
    		@RequestParam(value="months") int months) {
    	
    	Investor investor = investorService.getInvestor(id);
    	investor.setYearInvestReturns(financeService.calculateCompoundInterestMonthly(investor.getInitialInvestment(), interestRate, months, investor.getMonthlyInvestment()));
    	
    	Map<String, HashMap<Integer, Double>> result = new HashMap<String, HashMap<Integer, Double>>();
    	result.put(investor.getName(), investor.getYearInvestReturns());
    	return result;
    }
}