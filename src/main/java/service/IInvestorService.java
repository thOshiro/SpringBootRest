package service;

import java.util.List;

import entity.Investor;

public interface IInvestorService {
	
	/**
	 * Register a new Investor
	 * @param name investors name
	 * @param initialInvest initial amount invest is willing to apply
	 * @param monthlyInvest monthly amount invest is willing to apply
	 * 
	 * @return investor registered
	 */
	public Investor addInvestor(String name, Double initialInvest, Double monthlyInvest);
	
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
	public void deleteInvestor(long id);
	
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
	
	/**
	 * Get a registered investor
	 * 
	 * @param investorId the investor name to return
	 * 
	 * @return investor registered if any
	 */
	public Investor getInvestor(String investor);
	
	/**
	 * Set investing plan of investor
	 * 
	 * @param investorId investor id
	 * @param interestRate interest rate
	 * @param months period in months the investment will be applied
	 * 
	 * @return investor with new plan
	 */
	public Investor setInvestorPlan(long investorId, double interestRate, int months);
}
