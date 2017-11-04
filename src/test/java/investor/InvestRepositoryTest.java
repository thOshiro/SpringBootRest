package investor;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import entity.Investor;
import repository.InvestorRepository;

public class InvestRepositoryTest {
	
	private static InvestorRepository investorRepo;
	private static Investor investor1;
	private static Investor investor2;
	private static Investor investor3;
	
	
	@Before
	public void setUp() {
		investorRepo = mock(InvestorRepository.class);
		
		Calendar date = GregorianCalendar.getInstance();
		
		date.set(2017, Calendar.NOVEMBER, 01);
		Date currentDate = date.getTime();
		investor1 = new Investor(0, "Ulysses", new SimpleDateFormat("dd-MM-yyyy").format(currentDate), 100.00, 0.00);
		
		date.set(2017, Calendar.JANUARY, 01);
		currentDate = date.getTime();
		investor2 = new Investor(0, "Achilles", new SimpleDateFormat("dd-MM-yyyy").format(currentDate), 100.00, 100.00);
		
		date.set(2017, Calendar.JULY, 01);
		currentDate = date.getTime();
		investor3 = new Investor(0, "Medusa", new SimpleDateFormat("dd-MM-yyyy").format(currentDate), 500.00, 300.00);
	}
	
	@Test
	public void testAddInvestor() {
		
	}
	
	@Test
	public void testgetAllInvestors() {
		
	}

	@Test
	public void testDeleteInvestor() {
		
	}
	
	@Test
	public void testDeleteAllInvestors() {
		
	}
}
