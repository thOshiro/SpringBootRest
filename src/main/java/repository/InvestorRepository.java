package repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import entity.Investor;

@Repository
public class InvestorRepository {
	
	private static InvestorRepository instance; 
	List<Investor> investors;
	
	private InvestorRepository() {
		investors = new ArrayList<Investor>();
	}
	
	public static InvestorRepository getInstance() {
		if(instance == null)
			return instance = new InvestorRepository();
		return instance;
	}

	public Investor addInvestor(Investor investor) {
		investors.add(investor);
		return investor;
	}
	
	public List<Investor> getAllInvestor(){
		return investors;
	}
	
	public Investor deleteInvestor(long id) {
		int i=0;
		for(Investor investor: investors) {
			if(investor.getId() == id) {
				investors.remove(i);
				return investor;
			}
			i++;
		}
		return null;
	}
	
	public Investor getInvestor(long id) {
		for(Investor investor: investors) {
			if(investor.getId() == id) {
				return investor;
			}
		}
		return null;
	}
	
	public void deleteAllInvestors() {
		investors.clear();
	}
}