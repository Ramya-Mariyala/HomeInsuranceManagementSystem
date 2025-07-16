package com.capgemini.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Component
@Entity
public class PolicyHolder {

	@Id
	@Column(name = "policyholder_id")
	private int policyHolderId;
	@Column(name = "POLICYHOLDER_NAME")
	private String policyHolderName;
	@Column(name = "POLICY_NAME")
	private String policyName;
	@Column(name = "PREMIUIM_TYPE")
	private String premiumType;
	@Column(name = "CREDIT_CARD")
	private String creditCard;
	@Column
	private String dob;
	@Column
	private String occupation;
	@Column
	private double annualIncome;
	@Column
	private String isRetired;
	@Column
	private String ssn;
	@Column
	private String emailId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private HomeAddress address;

	@ManyToOne
	private Agent agent;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "POLICY_ID")
	private Policy policyId;

	public Policy getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Policy policyId) {
		this.policyId = policyId;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + policyHolderId;
		return result;
	}

	@Override
	public String toString() {
		return "PolicyHolder [policyHolderId=" + policyHolderId + ", policyHolderName=" + policyHolderName
				+ ", policyName=" + policyName + ", premiumType=" + premiumType + ", creditCard=" + creditCard
				+ ", dob=" + dob + ", occupation=" + occupation + ", annualIncome=" + annualIncome + ", isRetired="
				+ isRetired + ", ssn=" + ssn + ", emailId=" + emailId + ", address=" + address + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PolicyHolder other = (PolicyHolder) obj;
		if (policyHolderId != other.policyHolderId)
			return false;
		return true;
	}

	public int getPolicyHolderId() {
		return policyHolderId;
	}

	public void setPolicyHolderId(int policyHolderId) {
		this.policyHolderId = policyHolderId;
	}

	public String getPolicyHolderName() {
		return policyHolderName;
	}

	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPremiumType() {
		return premiumType;
	}

	public void setPremiumType(String premiumType) {
		this.premiumType = premiumType;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public double getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(double annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getIsRetired() {
		return isRetired;
	}

	public void setIsRetired(String isRetired) {
		this.isRetired = isRetired;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public HomeAddress getAddress() {
		return address;
	}

	public void setAddress(HomeAddress address) {
		this.address = address;
	}

}
