package com.mahesh.Insurance_Management.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mahesh.Insurance_Management.Entity.InsurancePolicy;
import com.mahesh.Insurance_Management.Repository.InsuranceRepository;

@Repository
public class InsurancePolicyDao {
	
	@Autowired
	InsuranceRepository insuranceRepository;
	
	public InsurancePolicy insertInsurancePolicy(InsurancePolicy insurancePolicy) {
		return insuranceRepository.save(insurancePolicy);
	}
	
	// getById
	public InsurancePolicy getByInsurancePolicyId(int insurancePolicyId) {
		Optional<InsurancePolicy> optional = insuranceRepository.findById(insurancePolicyId);
		
		if(optional.isPresent()) {
			InsurancePolicy insurancePolicy = optional.get();
			return insurancePolicy;
		}else {
			return null;
		}
	}
	public InsurancePolicy updateInsurancePolicy(InsurancePolicy insurancePolicy, int insurancePolicyId) {
		Optional<InsurancePolicy> optional = insuranceRepository.findById(insurancePolicyId);
		
		InsurancePolicy insurancePolicy2 = optional.get();
		if((insurancePolicy.getInsurancePolicyNumber() != null) && (insurancePolicy.getInsurancePolicyType() != null) &&
				(insurancePolicy.getInsurancePolicyCoverageAmount()!= 0) && (insurancePolicy.getInsurancePolicyPremium() != null) &&
				(insurancePolicy.getInsurancePolicyStartDate()!= null) && (insurancePolicy.getInsurancePolicyEndDate()!=null)) {
			
			
			insurancePolicy2.setInsurancePolicyNumber(insurancePolicy.getInsurancePolicyNumber());
			insurancePolicy2.setInsurancePolicyType(insurancePolicy.getInsurancePolicyType());
			insurancePolicy2.setInsurancePolicyCoverageAmount(insurancePolicy.getInsurancePolicyCoverageAmount());
			insurancePolicy2.setInsurancePolicyPremium(insurancePolicy.getInsurancePolicyPremium());
			insurancePolicy2.setInsurancePolicyStartDate(insurancePolicy.getInsurancePolicyStartDate());
			insurancePolicy2.setInsurancePolicyEndDate(insurancePolicy.getInsurancePolicyEndDate());
			
			insuranceRepository.save(insurancePolicy2);
			return insurancePolicy;
		}else {
			return null;
		}
		
	}
	public InsurancePolicy deleteInsurancePolicy(InsurancePolicy insurancePolicy, int policyId){
		Optional<InsurancePolicy> optional = insuranceRepository.findById(policyId);
		
		if(optional.isPresent()) {
			insuranceRepository.delete(optional.get());
			return insurancePolicy;
		}else {
			return null;
		}
	}
	
	
	
	//display data
	public List<InsurancePolicy> displayAllPolicy(){
		return insuranceRepository.findAll();
	}

	
	
	
}







