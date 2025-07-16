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
public class Policy {
	
	@Id
	@Column(name = "Policy_id")
	private int policyId;
	@Column(name = "policy_date")
	private String policyEffectiveDate;
	@Column(name = "policy_enddate")
	private String policyEndDate;
	@Column(name = "policy_term")
	private int policyTerm;
	@Column(name = "policy_status")
	private String policyStatus;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "quote_Id")
	private Quote quote;

	@ManyToOne
	private Agent agent;

	public Quote getQuote() {
		return quote;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public String getPolicyEffectiveDate() {
		return policyEffectiveDate;
	}

	public void setPolicyEffectiveDate(String policyEffectiveDate) {
		this.policyEffectiveDate = policyEffectiveDate;
	}

	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", policyEffectiveDate=" + policyEffectiveDate + ", policyEndDate="
				+ policyEndDate + ", policyTerm=" + policyTerm + ", policyStatus=" + policyStatus + "]";
	}

	public String getPolicyEndDate() {
		return policyEndDate;
	}

	public void setPolicyEndDate(String policyEndDate) {
		this.policyEndDate = policyEndDate;
	}

	public int getPolicyTerm() {
		return policyTerm;
	}

	public void setPolicyTerm(int policyTerm) {
		this.policyTerm = policyTerm;
	}

	public String getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + policyId;
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
		Policy other = (Policy) obj;
		if (policyId != other.policyId)
			return false;
		return true;
	}

	

}
