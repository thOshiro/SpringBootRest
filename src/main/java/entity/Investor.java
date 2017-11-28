package entity;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Investor {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	private String name;
	private Double initialInvestment;
	private Double monthlyInvestment;
	
	@Lob
	private Map<Integer, Double> investmentReturn;
	
	// for Jpa
	protected Investor() {
		
	}
	
	public Investor(String name, Double initialInvestment, Double monthlyInvestment) {
		this.name = name;
		this.initialInvestment = initialInvestment;
		this.monthlyInvestment = monthlyInvestment;
	}
	
	public Investor(String name, Double initialInvestment, Double monthlyInvestment,Map<Integer, Double> yearInvestReturns) {
		this.name = name;
		this.initialInvestment = initialInvestment;
		this.monthlyInvestment = monthlyInvestment;
		this.investmentReturn = yearInvestReturns;
	}

	public Map<Integer, Double> getYearInvestReturns() {
		return investmentReturn;
	}

	public void setYearInvestReturns(Map<Integer, Double> yearInvestReturns) {
		this.investmentReturn = yearInvestReturns;
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
