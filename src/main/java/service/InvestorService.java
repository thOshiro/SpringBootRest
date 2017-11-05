package service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Investor;
import repository.InvestorRepository;

@Service
public class InvestorService {
	
	@Autowired
	private InvestorRepository investRepo;
	
	public Investor addInvestor(long id, String name, Date accessDate, Double initialInvest, Double monthlyInvest) {
		
		Investor investor = new Investor(id, name, 
				new SimpleDateFormat("dd-MM-yyyy").format(accessDate),
				initialInvest,
				monthlyInvest);
		
		investRepo.addInvestor(investor);
		
		return investor;
	}
	
	public List<Investor> findAllInvestors(){
		return investRepo.getAllInvestor();
	}
	
	public Investor deleteInvestor(long id) {
		return investRepo.deleteInvestor(id);
	}
	
	public void deleteAllInvestors() {
		investRepo.deleteAllInvestors();
	}
	
	public Investor getInvestor(long investorId) {
		return investRepo.getInvestor(investorId);
	}
}
