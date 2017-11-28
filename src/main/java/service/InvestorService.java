package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.Investor;
import repository.InvestorRepo;

@Service
public class InvestorService implements IInvestorService{
	
	@Autowired
	private InvestorRepo investRepo;
	
	@Autowired
	private IFinanceCalculatorService financeService;
	

	@Override
	public Investor addInvestor(String name, Double initialInvest, Double monthlyInvest) {
		
		Investor investor = new Investor(name, 
				initialInvest,
				monthlyInvest);
		
		investRepo.save(investor);
		
		return investor;
	}
	
	@Override
	public List<Investor> findAllInvestors(){
		return (List<Investor>) investRepo.findAll();
	}
	
	@Override
	public void deleteInvestor(long id) {
		investRepo.delete(id);
	}
	
	@Override
	public void deleteAllInvestors() {
		investRepo.deleteAll();
	}
	
	@Override
	public Investor getInvestor(long investorId) {
		return investRepo.findOne(investorId);
	}
	
	@Override
	public Investor getInvestor(String name) {
		return investRepo.findByName(name);
	}

	@Override
	public Investor setInvestorPlan(long investorId, double interestRate, int months) {
		Investor investor = investRepo.findOne(investorId);
		investor.setYearInvestReturns(financeService.calculateCompoundInterestMonthly(investor.getInitialInvestment(), interestRate, months, investor.getMonthlyInvestment()));
		investRepo.save(investor);
		return investor;
	}
}
