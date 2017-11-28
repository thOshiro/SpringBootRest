package repositoryTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import entity.Investor;
import repository.InvestorRepo;
import service.FinanceCalculatorService;

public class InvestorRepoTest {
	
	private static InvestorRepo mockedInvestorRepo;
	
	private static Investor investor1;
	private static Investor investor2;
	private static Investor investor3;
	
	@Before
	public void setUp() {
		mockedInvestorRepo = mock(InvestorRepo.class);
		
		investor1 = new Investor("Ulysses", 100.00, 0.00);

		investor2 = new Investor("Achilles", 100.00, 100.00);

		investor3 = new Investor("Medusa", 500.00, 300.00);
		
		when(mockedInvestorRepo.findAll()).thenReturn(Arrays.asList(investor1, investor2, investor3));
		when(mockedInvestorRepo.save(investor3)).thenReturn(investor3);
	}
	
	@Test
	public void addInvestorTest() {
		Investor investor = mockedInvestorRepo.save(investor3);
		assertNotNull(investor);
		assertEquals(investor3, investor);
	}
	
	@Test
	public void testGetAllInvestors() {
		List<Investor> investors = (List<Investor>) mockedInvestorRepo.findAll();
		assertEquals(3, investors.size());
		
		Investor investor = investors.get(1);
		
		assertEquals(investor.getName(), "Achilles");
		
		assertEquals(investor.getInitialInvestment(), new Double("100.00"));
		
		assertEquals(investor.getMonthlyInvestment(), new Double("100.00"));
	}
	
	
	@Test
	public void testSetInvestmentReturn() {
		Investor investor = new Investor("A", 100.00, 0.00);
		
		FinanceCalculatorService s = new FinanceCalculatorService();
		Map<Integer, Double> invest = s.calculateCompoundInterestMonthly(100.0, 10, 10, 0.00);
		investor.setYearInvestReturns(invest);
		
		mockedInvestorRepo.save(investor);
	}
}
