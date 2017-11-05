package investor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import entity.Investor;
import service.FinanceCalculatorService;
import service.InvestorService;
import springboot.Welcome;
import springboot.springController.InvestorController;

// Provides Spring test context
@RunWith(SpringRunner.class)

// Testing only investor controller
@WebMvcTest(value = InvestorController.class, secure=false)

@ContextConfiguration(classes={Welcome.class})
public class InvestorControllerTest {

    @Autowired
    private MockMvc mockMvc;
	
	@MockBean
	InvestorService investorSer;
	
	@MockBean
	private FinanceCalculatorService financeService;
	
	@InjectMocks
	InvestorController investorController;
	
	
	private static final long INVESTOR1_ID = 0;
	private static final String INVESTOR1_NAME = "Thomas";
	private static final Double INVESTOR1_INITIAL_INVESTMENT = 100.00;
	private static final Double INVESTOR1_MONTHLY_INVESTMENT = 0.00;
	private Investor investor1;
	
	@Before
	public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(investorController).build();
		
		
		
		investor1 = new Investor(INVESTOR1_ID, INVESTOR1_NAME, INVESTOR1_INITIAL_INVESTMENT, INVESTOR1_MONTHLY_INVESTMENT);

		when(investorSer.addInvestor(INVESTOR1_ID, INVESTOR1_NAME, INVESTOR1_INITIAL_INVESTMENT, INVESTOR1_MONTHLY_INVESTMENT)).
		thenReturn(investor1);
	}
	
	@Test
	public void testRegisterInvestor() throws Exception {
		
		mockMvc.perform(
	            post("http://localhost:8080/registerInvestor?name=Thomas&initialInvest=100&monthlyInvest=0")
	                    .contentType(MediaType.APPLICATION_JSON)
	                    .content(asJsonString(investor1)))
	            .andExpect(status().isOk());
	    verify(investorSer, times(1)).addInvestor(INVESTOR1_ID, INVESTOR1_NAME, INVESTOR1_INITIAL_INVESTMENT, INVESTOR1_MONTHLY_INVESTMENT);
	    verifyNoMoreInteractions(investorSer);
	}
	
	@Test
	public void testListInvestor() throws Exception {
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/listInvestors").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		String expected = "[]";		
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
		
		Investor investor = investorSer.addInvestor(INVESTOR1_ID, INVESTOR1_NAME, INVESTOR1_INITIAL_INVESTMENT, INVESTOR1_MONTHLY_INVESTMENT);
		assertNotNull(investor);
		assertEquals(investor1, investor);
	}
	
	private static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
