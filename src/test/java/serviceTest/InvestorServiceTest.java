package serviceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import entity.Investor;
import repository.InvestorRepo;
import service.IFinanceCalculatorService;
import service.InvestorService;


public class InvestorServiceTest {

	@InjectMocks
	private InvestorService investorService = new InvestorService();
	
	@Mock
	private InvestorRepo investorRepo;
	
	@Mock
	private IFinanceCalculatorService financeService;
	
	private static final String INVESTOR1_NAME = "Thomas";
	private static final double INVESTOR1_INITIAL_INVESTMENT = 100.00;
	private static final double INVESTOR1_MONTHLY_INVESTMENT = 0.00;
	private Investor investor1;
	
	private static final String INVESTOR2_NAME = "Jerry";
	private static final Double INVESTOR2_INITIAL_INVESTMENT = 100.00;
	private static final Double INVESTOR2_MONTHLY_INVESTMENT = 50.00;
	private Investor investor2;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		investor1 = new Investor(INVESTOR1_NAME, INVESTOR1_INITIAL_INVESTMENT, INVESTOR1_MONTHLY_INVESTMENT);
		investor2 = new Investor(INVESTOR2_NAME, INVESTOR2_INITIAL_INVESTMENT, INVESTOR2_MONTHLY_INVESTMENT);
	}
	
	@Test 
	public void testAddInvestor() {
		Investor investor = investorService.addInvestor(INVESTOR1_NAME, INVESTOR1_INITIAL_INVESTMENT, INVESTOR1_MONTHLY_INVESTMENT);
		
		assertNotNull(investor);
		assertEquals(investor.getName(), INVESTOR1_NAME);
		assertEquals(investor.getInitialInvestment(), new Double(INVESTOR1_INITIAL_INVESTMENT));
		assertEquals(investor.getMonthlyInvestment(), new Double(INVESTOR1_MONTHLY_INVESTMENT));
	}
	
	@Test 
	public void testFindAllInvestor() {
		
		when(investorRepo.findAll()).thenReturn(Arrays.asList(investor1, investor2));
		
		List<Investor> investors = investorService.findAllInvestors();
		assertEquals(2, investors.size());
		
		Investor investor = investors.get(0);

		assertEquals(investor.getName(), INVESTOR1_NAME);		
		assertEquals(investor.getInitialInvestment(), new Double(INVESTOR1_INITIAL_INVESTMENT));
		assertEquals(investor.getMonthlyInvestment(), new Double(INVESTOR1_MONTHLY_INVESTMENT));
		
		investor = investors.get(1);

		assertEquals(investor.getName(), INVESTOR2_NAME);		
		assertEquals(investor.getInitialInvestment(), INVESTOR2_INITIAL_INVESTMENT);
		assertEquals(investor.getMonthlyInvestment(), INVESTOR2_MONTHLY_INVESTMENT);
	}
	
	@Test 
	public void testDeleteInvestor() {
		
		investorService.deleteInvestor(0);
		
		verify(investorRepo, Mockito.only()).delete((long) 0);
	}
	
	@Test 
	public void testDeleteAllInvestors() {
		
		investorService.deleteAllInvestors();
		
		verify(investorRepo, Mockito.only()).deleteAll();
	}
	
	@Test
	public void testGetInvestorById() {
		when(investorRepo.findOne((long) 0)).thenReturn(investor1);
		
		Investor investor = investorService.getInvestor((long) 0);
		
		assertNotNull(investor);
		assertEquals(investor.getName(), INVESTOR1_NAME);		
		assertEquals(investor.getInitialInvestment(), new Double(INVESTOR1_INITIAL_INVESTMENT));
		assertEquals(investor.getMonthlyInvestment(), new Double(INVESTOR1_MONTHLY_INVESTMENT));
	}
	
	@Test
	public void testGetInvestor() {
		when(investorRepo.findByName(INVESTOR1_NAME)).thenReturn(investor1);
		
		Investor investor = investorService.getInvestor(INVESTOR1_NAME);
		
		assertNotNull(investor);
		assertEquals(investor.getName(), INVESTOR1_NAME);		
		assertEquals(investor.getInitialInvestment(), new Double(INVESTOR1_INITIAL_INVESTMENT));
		assertEquals(investor.getMonthlyInvestment(), new Double(INVESTOR1_MONTHLY_INVESTMENT));
	}

	@Test 
	public void testSetInvestorPlan() {
		double interestRate = 10.0;
		int months = 1;
		HashMap<Integer, Double> investReturn = new HashMap<Integer, Double>();
		investReturn.put(0, 110.00);
		
		when(investorRepo.findOne((long) 0)).thenReturn(investor1);
		when(financeService.calculateCompoundInterestMonthly(INVESTOR1_INITIAL_INVESTMENT, interestRate , months, INVESTOR1_MONTHLY_INVESTMENT)).thenReturn(investReturn);
		
		Investor investor = investorService.setInvestorPlan(0, interestRate, months);
		
		assertNotNull(investor);
		assertEquals(investor.getYearInvestReturns().get(0), investReturn.get(0));
	}
}
