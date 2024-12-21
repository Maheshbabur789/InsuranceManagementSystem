package com.mahesh.Insurance_Management.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mahesh.Insurance_Management.Entity.Client;
import com.mahesh.Insurance_Management.Repository.ClientRepository;

@Repository
public class ClientDao {
	
	@Autowired
	ClientRepository clientrepo;
	
	public Client insertClient(Client client) {
		return clientrepo.save(client);
	}
	
	public Client getClientById(int clientId) {
		Optional<Client> optional = clientrepo.findById(clientId);
		
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	public Client updateClient(Client client) {
		return clientrepo.save(client);
	}
	
	//delete Client-----------------------------------------------------------------------------------------
	public Client deleteClient(Client client, int clientId) {
		Optional<Client> optional = clientrepo.findById(clientId);
		
		if(optional.isPresent()) {
			clientrepo.delete(optional.get());
			return client;
		}else {
			return null;
		}
	}
	
		
		//display client
		public List<Client> displayAllCLient(){
			return clientrepo.findAll();
		}

}
