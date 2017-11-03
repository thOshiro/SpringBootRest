package repository;

import java.util.ArrayList;
import java.util.List;

import entity.Investor;

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

	public void addInvestor(Investor user) {
		investors.add(user);
	}
	
	public List<Investor> getAllInvestor(){
		return investors;
	}
	
	public void deleteInvestor(long id) {
		int i=0;
		for(Investor investor: investors) {
			if(investor.getId() == id) {
				investors.remove(i);
				break;
			}
			i++;
		}
	}
	
	public void deleteAllInvestors() {
		investors.clear();
	}
}