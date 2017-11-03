package springboot.springController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import entity.Investor;
import repository.InvestorRepository;

@RestController
public class InvestorController {

	private static final double INTEREST_RATE = 7.5;
	private static final int INVESTMENT_PERIOD = 12;
	
	private final AtomicLong counter = new AtomicLong();
	private InvestorRepository userRepo = InvestorRepository.getInstance();
	
	@Autowired
	private MathController mathController;
	
	
	/**
	 * Register a new investor
	 * @param name investor name
	 * @param initialInvest investor initial value
	 * @param monthlyInvest investor monthly investment
	 * 
	 * @return The registered investor
	 */
	@RequestMapping("/registerUser")
	public Investor registerUser(@RequestParam(value="name", defaultValue="Stranger") String name,
			@RequestParam(value="initialInvest", defaultValue="0") Double initialInvest,
			@RequestParam(value="monthlyInvest", defaultValue="0") Double monthlyInvest) {
		Date currentDate = Calendar.getInstance().getTime();
		Investor user = new Investor(counter.incrementAndGet(), name, 
				new SimpleDateFormat("dd-MM-yyyy").format(currentDate),
				initialInvest,
				monthlyInvest,
				mathController.calculateCompoundInterestMonthly(initialInvest, INTEREST_RATE, INVESTMENT_PERIOD, monthlyInvest));
		
		userRepo.addInvestor(user);
		return user;
	}
	
	
	/**
	 * List all investors and their attributes.
	 * 
	 * @return list of investors 
	 */
    @RequestMapping("/listUsers")
    public List<Investor> getAllUsers() {
		return userRepo.getAllInvestor();
    }

}
