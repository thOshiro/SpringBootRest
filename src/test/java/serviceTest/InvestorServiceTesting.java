package serviceTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import entity.Investor;
import service.InvestorService;

@RunWith( SpringJUnit4ClassRunner.class)
public class InvestorServiceTesting {
	
	private static final String INVESTOR_1_NAME = "Ciclops";
	private static final Double INVESTOR_1_INITIAL_INVEST = 1000.00;
	private static final Double INVESTOR_1_MONTHLY_INVEST = 0.00;
	
	private InvestorService investorService;
	private Investor investor;
	

	@Before
	public void setUp() {
		investorService = new InvestorService();
		
		when(investor.getName()).thenReturn(INVESTOR_1_NAME);
		when(investor.getInitialInvestment()).thenReturn(INVESTOR_1_INITIAL_INVEST);
		when(investor.getMonthlyInvestment()).thenReturn(INVESTOR_1_MONTHLY_INVEST);
	}

	@Ignore
	@Test
	public void saveNewInvestor() {
		Investor investor = investorService.addInvestor(INVESTOR_1_NAME, INVESTOR_1_INITIAL_INVEST, INVESTOR_1_MONTHLY_INVEST);
		
		assertEquals(investor.getName(), investor.getName());
		assertEquals(INVESTOR_1_INITIAL_INVEST, investor.getInitialInvestment());
		assertEquals(INVESTOR_1_MONTHLY_INVEST, investor.getMonthlyInvestment());
	}

}
