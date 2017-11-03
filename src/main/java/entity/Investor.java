package entity;

import java.util.Map;

public class Investor {
	
	private final long id;
	private final String name;
	private String dateVisited;
	private Double initialInvestment;
	private Double monthlyInvestment;
	private Map<Integer, Double> yearInvestReturns;
	
	public Investor(long id, String name, String dateVisited, Double initialInvestment, Double monthlyInvestment,Map<Integer, Double> yearInvestReturns) {
		this.id = id;
		this.name = name;
		this.dateVisited = dateVisited;
		this.initialInvestment = initialInvestment;
		this.monthlyInvestment = monthlyInvestment;
		this.yearInvestReturns = yearInvestReturns;
	}

	public Map<Integer, Double> getYearInvestReturns() {
		return yearInvestReturns;
	}

	public void setYearInvestReturns(Map<Integer, Double> yearInvestReturns) {
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

	public String getDateVisited() {
		return dateVisited;
	}
}
