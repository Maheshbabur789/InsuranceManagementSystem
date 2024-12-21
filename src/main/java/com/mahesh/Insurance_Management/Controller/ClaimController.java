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

import com.mahesh.Insurance_Management.Entity.Claim;
import com.mahesh.Insurance_Management.Entity.ResponseStructure;
import com.mahesh.Insurance_Management.Service.ClaimService;

@RestController
public class ClaimController {
	
	@Autowired
	ClaimService claimservice;
	
	//insert
	@PostMapping("/saveClaim/{policyId}")
	public ResponseStructure<Claim> insertClaim(@RequestBody Claim claim,@PathVariable int policyId) {
		return claimservice.insertClaim(claim, policyId);
	}
	
	//getBYId
	@GetMapping("/getByClaimId/{claimId}")
	public ResponseStructure<Claim> getByClaimId(@PathVariable int claimId) {
		return claimservice.getByClaimId(claimId);
	}
	
	//delete
	@DeleteMapping("/deleteClaim/{claimId}")
	public ResponseStructure<Claim> deleteClaim(Claim claim, @PathVariable int claimId) {
		return claimservice.deleteClaim(claim, claimId);
	}	
	
	// update
	@PutMapping("/updateClaim/{claimId}")
	public ResponseStructure<Claim> updateClaim(@RequestBody Claim claim,@PathVariable int claimId) {
		return claimservice.updateClaim(claim, claimId);
	}
	
	//display
	@GetMapping("/displayAllClaim")
	public ResponseStructure<List<Claim>> displayAllClaim(){
		return claimservice.displayAllClaim();
	}	

}
