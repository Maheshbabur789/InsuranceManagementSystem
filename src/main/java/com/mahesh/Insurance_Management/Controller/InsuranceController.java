package com.mahesh.Insurance_Management.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mahesh.Insurance_Management.Entity.InsurancePolicy;
import com.mahesh.Insurance_Management.Entity.ResponseStructure;
import com.mahesh.Insurance_Management.Service.InsurancePolicyService;

@RestController
public class InsuranceController {
	
	@Autowired
	InsurancePolicyService insurancepolicyservice;
	
	//insert
	@PostMapping("/saveInsurancePolicy")
	public ResponseStructure<InsurancePolicy> insertInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy) {
		return insurancepolicyservice.insertInsurancePolicy(insurancePolicy);
	}	
	
	// getById
	@GetMapping("/getByInsurancePolicyId/{insurancePolicyId}")
	public ResponseStructure<InsurancePolicy> getByInsurancePolicyId(@PathVariable int insurancePolicyId) {
		return insurancepolicyservice.getByInsurancePolicyId(insurancePolicyId);
	}	
	
	//update
	@PutMapping("/updateInsurancePolicy/{insurancePolicyId}")
	public ResponseStructure<InsurancePolicy> updateInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy,@PathVariable int insurancePolicyId) {
		return insurancepolicyservice.updateInsurancePolicy(insurancePolicy, insurancePolicyId);
	}
	
	// delete
		@DeleteMapping("/deleteInsurancePolicy/{policyId}")
		public ResponseStructure<InsurancePolicy> deleteInsurancePolicy(InsurancePolicy insurancePolicy, @PathVariable int policyId){
			return insurancepolicyservice.deleteInsurancePolicy(insurancePolicy, policyId);
		}
		
	//display
	@GetMapping("/displayAllPolicy")
	public ResponseStructure<List<InsurancePolicy>> displayAllPolicy(){
		return insurancepolicyservice.displayAllPolicy();
	}	

}
