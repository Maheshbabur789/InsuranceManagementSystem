package com.mahesh.Insurance_Management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.mahesh.Insurance_Management.Entity.Client;

@Component
public interface ClientRepository extends JpaRepository<Client,Integer>{

}
