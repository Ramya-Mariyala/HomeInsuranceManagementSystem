package com.capgemini.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "Agents")
public class Agent {

	@Id
	@Column(name = "agent_id")
	private int agentId;
	@Column(name = "agent_name")
	private String agentName;
	@Column
	private String designation;
	@Column
	private String salary;
	@Column
	private String address;
	@Column
	private String email;
	@Column(name = "mobile_no")
	private String mobileNo;

	@OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
	private List<PolicyHolder> policyHoldersList = new ArrayList<>();

	@OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
	private List<Policy> policies = new ArrayList<>();

	public int getAgentId() {
		return agentId;
	}

	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public List<PolicyHolder> getPolicyHoldersList() {
		return policyHoldersList;
	}

	public void setPolicyHoldersList(List<PolicyHolder> policyHoldersList) {
		this.policyHoldersList = policyHoldersList;
	}

	public List<Policy> getPolicies() {
		return policies;
	}

	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + agentId;
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
		Agent other = (Agent) obj;
		if (agentId != other.agentId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agent [agentId=" + agentId + ", agentName=" + agentName + ", designation=" + designation + ", salary="
				+ salary + ", address=" + address + ", email=" + email + ", mobileNo=" + mobileNo + "]";
	}

}
