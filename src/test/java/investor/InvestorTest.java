package investor;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import entity.Investor;
import repository.InvestorRepository;

public class InvestorTest {

	InvestorRepository investRepo = InvestorRepository.getInstance();
	
	@Test
	public void addNewInvestor() {
		
		String name = "SomeGuy";
		Date currentDate = Calendar.getInstance().getTime();
		Double initialInvest = 100.00;
		Double monthlyInvest = 0.00;
		
		Investor investor = new Investor(1,name, new SimpleDateFormat("dd-MM-yyyy").format(currentDate), initialInvest, monthlyInvest, null);
		
		investRepo.addInvestor(investor);
		List<Investor> investors = InvestorRepository.getInstance().getAllInvestor();
		assertEquals(name, 	investors.get(0).getName());
		assertEquals(initialInvest, investors.get(0).getInitialInvestment());
		assertEquals(monthlyInvest, investors.get(0).getMonthlyInvestment());
	}
}