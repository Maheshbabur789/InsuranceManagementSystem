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

import com.mahesh.Insurance_Management.Entity.Client;
import com.mahesh.Insurance_Management.Entity.ResponseStructure;
import com.mahesh.Insurance_Management.Service.ClientService;

@RestController
public class ClientController {
	
	@Autowired
	ClientService clientservice;
	
	//insert
	@PostMapping("/saveClient/{policyId}")
	public ResponseStructure<Client> insertClient(@RequestBody Client client,@PathVariable int policyId){
		return clientservice.insertClient(client, policyId);
	}
	
	//getById
	@GetMapping("/getClientById/{clientId}")
	public ResponseStructure<Client> getClientById(@PathVariable int clientId) {
		return clientservice.getClientById(clientId);
	}
	
	//update
	@PutMapping("/updateClient/{clientId}")
	public ResponseStructure<Client> updateClient(@RequestBody Client client,@PathVariable int clientId) {
		return clientservice.updateClient(client, clientId);
	}	
	
	//delete
	@DeleteMapping("/deleteClient/{clientId}")
	public ResponseStructure<Client> deleteClient(Client client,@PathVariable int clientId) {
		return clientservice.deleteClient(client, clientId);
	}	
	
	//display
	@GetMapping("/displayAllClient")
	public ResponseStructure<List<Client>> displayAllCLient(){
		return clientservice.displayAllCLient();
	}
	
	
	

}
