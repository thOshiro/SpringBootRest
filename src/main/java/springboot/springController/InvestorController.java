package springboot.springController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entity.Investor;
import service.IInvestorService;

@RestController
public class InvestorController {
	
	@Autowired
	private IInvestorService investorService;
	
	/**
	 * Register a new investor
	 * @param name investor name
	 * @param initialInvest investor initial value
	 * @param monthlyInvest investor monthly investment
	 * 
	 * @return The registered investor
	 */
	@RequestMapping("/registerInvestor")
	public Investor registerInvestor(@RequestParam(value="name", defaultValue="Stranger") String name,
			@RequestParam(value="initialInvest", defaultValue="0") Double initialInvest,
			@RequestParam(value="monthlyInvest", defaultValue="0") Double monthlyInvest) {
		
		return investorService.addInvestor(name, initialInvest, monthlyInvest);
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
    public Investor getInvestorYearReturn(@RequestParam(value="investorId")long id, 
    		@RequestParam(value="interestRate") double interestRate, 
    		@RequestParam(value="months") int months) {
    	
    	return investorService.setInvestorPlan(id, interestRate, months);
    }
}