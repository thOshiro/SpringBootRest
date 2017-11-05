package investor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import entity.Investor;
import service.InvestorService;

public class InvestorServiceTest {


	private static InvestorService mockedInvestorSer;
	
	private static final long INVESTOR1_ID = 0;
	private static final String INVESTOR1_NAME = "Thomas";
	private static final Double INVESTOR1_INITIAL_INVESTMENT = 100.00;
	private static final Double INVESTOR1_MONTHLY_INVESTMENT = 0.00;
	private Investor investor1;
	
	private static final long INVESTOR2_ID = 0;
	private static final String INVESTOR2_NAME = "Jerry";
	private static final Double INVESTOR2_INITIAL_INVESTMENT = 100.00;
	private static final Double INVESTOR2_MONTHLY_INVESTMENT = 50.00;
	private Investor investor2;
	
	
	@Before
	public void setUp() {
		
		mockedInvestorSer = mock(InvestorService.class);
		
		investor1 = new Investor(INVESTOR1_ID, INVESTOR1_NAME, INVESTOR1_INITIAL_INVESTMENT, INVESTOR1_MONTHLY_INVESTMENT);
		investor2 = new Investor(INVESTOR2_ID, INVESTOR2_NAME, INVESTOR2_INITIAL_INVESTMENT, INVESTOR2_MONTHLY_INVESTMENT);
		
		when(mockedInvestorSer.addInvestor(INVESTOR1_ID, INVESTOR1_NAME, INVESTOR1_INITIAL_INVESTMENT, INVESTOR1_MONTHLY_INVESTMENT)).thenReturn(investor1);
		when(mockedInvestorSer.findAllInvestors()).thenReturn(Arrays.asList(investor1, investor2));
		when(mockedInvestorSer.deleteInvestor(0)).thenReturn(investor1);
		when(mockedInvestorSer.getInvestor(0)).thenReturn(investor1);
	}
	
	@Test 
	public void testAddInvestor() {
		Investor investor = mockedInvestorSer.addInvestor(INVESTOR1_ID, INVESTOR1_NAME, INVESTOR1_INITIAL_INVESTMENT, INVESTOR1_MONTHLY_INVESTMENT);
		assertNotNull(investor);
		assertEquals(investor1, investor);
	}
	
	@Test 
	public void testFindAllInvestor() {
		List<Investor> investors = mockedInvestorSer.findAllInvestors();
		assertEquals(2, investors.size());
		
		Investor investor = investors.get(0);
		
		assertEquals(investor.getId(), INVESTOR1_ID);
		
		assertEquals(investor.getName(), INVESTOR1_NAME);
		
		assertEquals(investor.getInitialInvestment(), INVESTOR1_INITIAL_INVESTMENT);
		
		assertEquals(investor.getMonthlyInvestment(), INVESTOR1_MONTHLY_INVESTMENT);
	}
	
	@Test 
	public void testDeleteInvestor() {
		Investor investor = mockedInvestorSer.deleteInvestor(0);
		assertNotNull(investor);
		assertEquals(investor1, investor);
	}
	
	@Test 
	public void testDeleteAllInvestors() {
		List<Investor> investors = mockedInvestorSer.findAllInvestors();
		assertEquals(2, investors.size());
		
		mockedInvestorSer.deleteAllInvestors();
		
		investors = mockedInvestorSer.findAllInvestors();
		assertEquals(2, investors.size());
	}
	
	@Test
	public void testGetInvestor() {
		Investor investor = mockedInvestorSer.getInvestor(0);
		assertNotNull(investor);
		assertEquals(investor1, investor);
	}
}
