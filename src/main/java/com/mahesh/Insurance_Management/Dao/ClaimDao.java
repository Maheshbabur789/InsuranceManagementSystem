package com.mahesh.Insurance_Management.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mahesh.Insurance_Management.Entity.Claim;
import com.mahesh.Insurance_Management.Repository.ClaimRepository;

@Repository
public class ClaimDao {
	
	@Autowired
	private ClaimRepository claimrepo;

	public Claim insertClaim(Claim claim) {
		return claimrepo.save(claim);	
	}
	
	public Claim getByClaimId(int claimId) {
		Optional<Claim> optional = claimrepo.findById(claimId);
		
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	public Claim deleteClaim(Claim claim, int claimId) {
		Optional<Claim> optional = claimrepo.findById(claimId);
		
		if(optional.isPresent()) {
			claimrepo.delete(optional.get());
			return claim;
		}else {
			return null;
		}
	}
	public Claim updateClaim(Claim claim) {
		return claimrepo.save(claim);
	}
	
	
	public List<Claim> displayAllClaim(){
		return claimrepo.findAll();
	}
}
