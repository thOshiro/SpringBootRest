package entity;

import java.util.HashMap;

public class Investor {
	
	private final long id;
	private final String name;
	private Double initialInvestment;
	private Double monthlyInvestment;
	private HashMap<Integer, Double> yearInvestReturns;
	
	public Investor(long id, String name, Double initialInvestment, Double monthlyInvestment) {
		this.id = id;
		this.name = name;
		this.initialInvestment = initialInvestment;
		this.monthlyInvestment = monthlyInvestment;
	}
	
	public Investor(long id, String name, Double initialInvestment, Double monthlyInvestment,HashMap<Integer, Double> yearInvestReturns) {
		this.id = id;
		this.name = name;
		this.initialInvestment = initialInvestment;
		this.monthlyInvestment = monthlyInvestment;
		this.yearInvestReturns = yearInvestReturns;
	}

	public HashMap<Integer, Double> getYearInvestReturns() {
		return yearInvestReturns;
	}

	public void setYearInvestReturns(HashMap<Integer, Double> yearInvestReturns) {
		this.yearInvestReturns = yearInvestReturns;
	}

	public Double getInitialInvestment() {
		return initialInvestment;
	}

	public void setInitialInvestment(Double initialInvestment) {
		this.initialInvestment = initialInvestment;
	}

	public Double getMonthlyInvestment() {
		return monthlyInvestment;
	}

	public void setMonthlyInvestment(Double monthlyInvestment) {
		this.monthlyInvestment = monthlyInvestment;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
