package com.octo.livecoding;

/**
 * 10/10/2012
 * @author gandinmathieu
 *
 */
public class Result {

	private String departement;
	private String manager;
	private Double netProfit;
	private Double operatingExpense;
	
	// Boring getters & setters
	
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public Double getNetProfit() {
		return netProfit;
	}
	public void setNetProfit(Double netProfit) {
		this.netProfit = netProfit;
	}
	public Double getOperatingExpense() {
		return operatingExpense;
	}
	public void setOperatingExpense(Double operatingExpense) {
		this.operatingExpense = operatingExpense;
	}
	
}
