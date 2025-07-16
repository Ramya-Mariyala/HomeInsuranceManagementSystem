package com.capgemini.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Quote {

	@Id
	@Column(name = "quote_Id")
	private int quoteId;

	@Column(name = "Premium_Type")
	private String premiumType;

	@Column(name = "Premium")
	private double premium;

	@Column(name = "Dwelling_Coverage")
	private double dwellingCoverage;

	@Column(name = "Detachedstructure_Coverage")
	private double detachedStructureCoverage;

	@Column(name = "Personalproperty_Coverage")
	private double personalPropertyCoverage;

	@Column(name = "Additional_Livingexpense")
	private double additionalLivingExpense;

	@Column(name = "Medical_Expense")
	private double medicalExpense;

	@Column(name = "Deductible_Amount")
	private double deductableAmount;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "property_id")
	private Property property;

	


	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public Quote() {

	}

	public Quote(int quoteId, String premiumType, double premium, double dwellingCoverage,
			double detachedStructureCoverage, double personalPropertyCoverage, double additionalLivingExpense,
			double medicalExpense, double deductableAmount) {
		super();
		this.quoteId = quoteId;
		this.premiumType = premiumType;
		this.premium = premium;
		this.dwellingCoverage = dwellingCoverage;
		this.detachedStructureCoverage = detachedStructureCoverage;
		this.personalPropertyCoverage = personalPropertyCoverage;
		this.additionalLivingExpense = additionalLivingExpense;
		this.medicalExpense = medicalExpense;
		this.deductableAmount = deductableAmount;
	}

	public int getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(int quoteId) {
		this.quoteId = quoteId;
	}

	public String getPremiumType() {
		return premiumType;
	}

	public void setPremiumType(String premiumType) {
		this.premiumType = premiumType;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public double getDwellingCoverage() {
		return dwellingCoverage;
	}

	public void setDwellingCoverage(double dwellingCoverage) {
		this.dwellingCoverage = dwellingCoverage;
	}

	public double getDetachedStructureCoverage() {
		return detachedStructureCoverage;
	}

	public void setDetachedStructureCoverage(double detachedStructureCoverage) {
		this.detachedStructureCoverage = detachedStructureCoverage;
	}

	public double getPersonalPropertyCoverage() {
		return personalPropertyCoverage;
	}

	public void setPersonalPropertyCoverage(double personalPropertyCoverage) {
		this.personalPropertyCoverage = personalPropertyCoverage;
	}

	public double getAdditionalLivingExpense() {
		return additionalLivingExpense;
	}

	public void setAdditionalLivingExpense(double additionalLivingExpense) {
		this.additionalLivingExpense = additionalLivingExpense;
	}

	public double getMedicalExpense() {
		return medicalExpense;
	}

	public void setMedicalExpense(double medicalExpense) {
		this.medicalExpense = medicalExpense;
	}

	

	public double getDeductableAmount() {
		return deductableAmount;
	}

	public void setDeductableAmount(double deductableAmount) {
		this.deductableAmount = deductableAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + quoteId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quote other = (Quote) obj;
		if (quoteId != other.quoteId)
			return false;
		return true;
	}

}
