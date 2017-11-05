package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Investor;
import repository.InvestorRepository;

@Service
public class InvestorService implements IInvestorService{
	
	@Autowired
	private InvestorRepository investRepo;
	
	@Override
	public Investor addInvestor(long id, String name, Double initialInvest, Double monthlyInvest) {
		
		Investor investor = new Investor(id, name, 
				initialInvest,
				monthlyInvest);
		
		investRepo.addInvestor(investor);
		
		return investor;
	}
	
	@Override
	public List<Investor> findAllInvestors(){
		return investRepo.getAllInvestor();
	}
	
	@Override
	public Investor deleteInvestor(long id) {
		return investRepo.deleteInvestor(id);
	}
	
	@Override
	public void deleteAllInvestors() {
		investRepo.deleteAllInvestors();
	}
	
	@Override
	public Investor getInvestor(long investorId) {
		return investRepo.getInvestor(investorId);
	}
}
