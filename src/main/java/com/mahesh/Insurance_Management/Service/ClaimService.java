package com.mahesh.Insurance_Management.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mahesh.Insurance_Management.Dao.ClaimDao;
import com.mahesh.Insurance_Management.Dao.InsurancePolicyDao;
import com.mahesh.Insurance_Management.Entity.Claim;
import com.mahesh.Insurance_Management.Entity.InsurancePolicy;
import com.mahesh.Insurance_Management.Entity.ResponseStructure;

@Service
public class ClaimService {
	
	@Autowired
	private ClaimDao claimDao;
	
	@Autowired
	private InsurancePolicyDao insurancePolicyDao;
	
	@Autowired
	private ResponseStructure<Claim> responseStructure;
	
	@Autowired
	private ResponseStructure<List<Claim>> responseStructure2;
	
	public ResponseStructure<Claim> insertClaim(Claim claim, int policyId) {
		InsurancePolicy insurancePolicy = insurancePolicyDao.getByInsurancePolicyId(policyId);
		
		if(insurancePolicy != null) {
			claim.setInsurancePolicy(insurancePolicy);
			claimDao.insertClaim(claim);
			
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Claimed successfully");
			responseStructure.setData(claim);
			return responseStructure;
		}else {
			responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMsg("Not Cliamed yet please check again ");
			responseStructure.setData(null);
			return responseStructure;
		}
	}
	
	// getByClaimId-----------------------------------------------------------------------------
	public ResponseStructure<Claim> getByClaimId(int claimId) {
		Claim claim = claimDao.getByClaimId(claimId);
		
		if(claim != null) {
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("this calim id is present");
			responseStructure.setData(claim);
		
		}else {
		responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("please check claim id it is not present in our database");
		responseStructure.setData(null);
		return responseStructure;
		}
		return responseStructure;
	}	
	
	public ResponseStructure<Claim> deleteClaim(Claim claim, int claimId) {
		Claim claim2 = claimDao.deleteClaim(claim, claimId);
		
		if(claim2 != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMsg("Claim deleted successfully");
			responseStructure.setData(claim2);
		
		}else {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure.setMsg("Claim is not deleted ");
			responseStructure.setData(null);
			return responseStructure;
			
		}
		return responseStructure;
	}	
	
	
	public ResponseStructure<Claim> updateClaim(Claim claim, int claimId) {
		Claim claim2 = claimDao.getByClaimId(claimId);
		
		if(claim2 != null) {
			claim2.setClaimNumber(claim.getClaimNumber());
			claim2.setClaimDate(claim.getClaimDate());
			claim2.setClaimDescription(claim.getClaimDescription());
			claim2.setClaimStatus(claim.getClaimStatus());
			
			claimDao.updateClaim(claim2);
			responseStructure.setStatusCode(HttpStatus.ACCEPTED.value());
			responseStructure.setMsg("Claim updated Successfully");
			responseStructure.setData(claim2);
		
		}else {
		responseStructure.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			responseStructure.setMsg("Given id is not present in database");
			responseStructure.setData(null);
			return responseStructure;
			
		}
		return responseStructure;
	}

	
	
	
	
	
	//displayAllClaim
	public ResponseStructure<List<Claim>> displayAllClaim(){
		List<Claim> claims = claimDao.displayAllClaim();
		
		if(claims != null) {
			responseStructure2.setStatusCode(HttpStatus.FOUND.value());
			responseStructure2.setMsg("Claims- Details");
			responseStructure2.setData(claims);
			return responseStructure2;
		}else {
			responseStructure2.setStatusCode(HttpStatus.NOT_FOUND.value());
			responseStructure2.setMsg("Claims Details are not available");
			responseStructure2.setData(null);
			return responseStructure2;
		}
	}	
}
