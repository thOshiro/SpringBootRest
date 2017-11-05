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
import repository.InvestorRepository;

public class InvestRepositoryTest {
	
	private static InvestorRepository mockedInvestorRepo;
	
	private static Investor investor1;
	private static Investor investor2;
	private static Investor investor3;
	
	
	@Before
	public void setUp() {
		mockedInvestorRepo = mock(InvestorRepository.class);
		
		investor1 = new Investor(0, "Ulysses", 100.00, 0.00);

		investor2 = new Investor(1, "Achilles", 100.00, 100.00);

		investor3 = new Investor(2, "Medusa", 500.00, 300.00);
		
		when(mockedInvestorRepo.getAllInvestor()).thenReturn(Arrays.asList(investor1, investor2, investor3));
		when(mockedInvestorRepo.getInvestor(0)).thenReturn(investor1);
		when(mockedInvestorRepo.addInvestor(investor3)).thenReturn(investor3);
		when(mockedInvestorRepo.deleteInvestor(2)).thenReturn(investor3);
	}
	
	@Test
	public void testAddInvestor() {
		Investor investor = mockedInvestorRepo.addInvestor(investor3);
		assertNotNull(investor);
		assertEquals(investor3, investor);
	}
	
	@Test
	public void testGetAllInvestors() {
		List<Investor> investors = mockedInvestorRepo.getAllInvestor();
		assertEquals(3, investors.size());
		
		Investor investor = investors.get(1);
		
		assertEquals(investor.getId(), 1);
		
		assertEquals(investor.getName(), "Achilles");
		
		assertEquals(investor.getInitialInvestment(), new Double("100.00"));
		
		assertEquals(investor.getMonthlyInvestment(), new Double("100.00"));
	}

	@Test
	public void testDeleteInvestor() {
		Investor investor = mockedInvestorRepo.deleteInvestor(2);
		assertNotNull(investor);
		assertEquals(investor3, investor);
	}
	
	@Test
	public void testDeleteAllInvestors() {
		List<Investor> investors = mockedInvestorRepo.getAllInvestor();
		assertEquals(3, investors.size());
		
		mockedInvestorRepo.deleteAllInvestors();
		
		investors = mockedInvestorRepo.getAllInvestor();
		assertEquals(3, investors.size());
	}
	
	@Test
	public void testGetInvestor() {
		Investor investor = mockedInvestorRepo.getInvestor(0);
		assertNotNull(investor);
		assertEquals(investor1, investor);
	}
}
