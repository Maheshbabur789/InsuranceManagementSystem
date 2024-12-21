package com.mahesh.Insurance_Management.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.mahesh.Insurance_Management.Entity.InsurancePolicy;

@Component
public interface InsuranceRepository extends JpaRepository<InsurancePolicy ,Integer>{

	

}
