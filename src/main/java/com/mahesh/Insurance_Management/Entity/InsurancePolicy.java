package com.mahesh.Insurance_Management.Entity;

import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;

@Entity
public class InsurancePolicy {
	@Id
    
	@Column(name ="policyId")
	private int insurancePolicyId;
	
	@Column(name ="policyNumber")
	private String insurancePolicyNumber;
	
	@Column(name ="policyType")
	private String insurancePolicyType;
	
	@Column(name="policyCoverageAmount")
	private long insurancePolicyCoverageAmount;
	
	@Column(name ="policyPremium")
	private String insurancePolicyPremium;
	
	@Column(name ="policyStartDate")
	private String insurancePolicyStartDate;
	
	@Column(name ="policyEndDate")
	private String insurancePolicyEndDate;
	
	@OneToMany(mappedBy = "insurancePolicy", cascade = CascadeType.ALL)
	private List<Client> clients;
	
	@OneToOne(mappedBy = "insurancePolicy")
	private Claim claim;
	
	@Version
    private int version;

	public int getInsurancePolicyId() {
		return insurancePolicyId;
	}

	public void setInsurancePolicyId(int insurancePolicyId) {
		this.insurancePolicyId = insurancePolicyId;
	}

	public String getInsurancePolicyNumber() {
		return insurancePolicyNumber;
	}

	public void setInsurancePolicyNumber(String insurancePolicyNumber) {
		this.insurancePolicyNumber = insurancePolicyNumber;
	}

	public String getInsurancePolicyType() {
		return insurancePolicyType;
	}

	public void setInsurancePolicyType(String insurancePolicyType) {
		this.insurancePolicyType = insurancePolicyType;
	}

	public long getInsurancePolicyCoverageAmount() {
		return insurancePolicyCoverageAmount;
	}

	public void setInsurancePolicyCoverageAmount(long insurancePolicyCoverageAmount) {
		this.insurancePolicyCoverageAmount = insurancePolicyCoverageAmount;
	}

	public String getInsurancePolicyPremium() {
		return insurancePolicyPremium;
	}

	public void setInsurancePolicyPremium(String insurancePolicyPremium) {
		this.insurancePolicyPremium = insurancePolicyPremium;
	}

	public String getInsurancePolicyStartDate() {
		return insurancePolicyStartDate;
	}

	public void setInsurancePolicyStartDate(String insurancePolicyStartDate) {
		this.insurancePolicyStartDate = insurancePolicyStartDate;
	}

	public String getInsurancePolicyEndDate() {
		return insurancePolicyEndDate;
	}

	public void setInsurancePolicyEndDate(String insurancePolicyEndDate) {
		this.insurancePolicyEndDate = insurancePolicyEndDate;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

}
