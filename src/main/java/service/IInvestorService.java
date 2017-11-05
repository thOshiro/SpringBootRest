package service;

import java.util.List;

import entity.Investor;

public interface IInvestorService {
	
	/**
	 * Register a new Investor
	 * @param id investors id
	 * @param name investors name
	 * @param initialInvest initial amount invest is willing to apply
	 * @param monthlyInvest monthly amount invest is willing to apply
	 * 
	 * @return investor registered
	 */
	public Investor addInvestor(long id, String name, Double initialInvest, Double monthlyInvest);
	
	/**
	 * Find all registered investors 
	 */
	public List<Investor> findAllInvestors();
	
	/**
	 * Delete an investor
	 * 
	 * @param investor id
	 * 
	 *  @return investor deleted
	 */
	public Investor deleteInvestor(long id);
	
	/**
	 *  Delete all investors
	 */
	public void deleteAllInvestors();
	
	/**
	 * Get a registered investor
	 * 
	 * @param investorId the investor id to return
	 * 
	 * @return investor registered if any
	 */
	public Investor getInvestor(long investorId);
}
