package com.sip.amsatef.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.sip.amsatef.entities.Provider;
import com.sip.amsatef.repositories.ProviderRepository;

@Service
public class ProviderService {

	@Autowired
	ProviderRepository providerRepository;
	
	public Provider addProvider(Provider provider) {
		return providerRepository.save(provider);
	}
	
	public List<Provider> listProvider(){
		return (List<Provider>) providerRepository.findAll();
	}
	
	public String delete(int id) {
		
		if(providerRepository.existsById((long) id)) {
			providerRepository.deleteById((long) id);
			return "le povider avec l id "+id+"est supprimer";
			}
		else {
			return "id n'est pas trouver";
			}
	}
		   public Provider getProviderById(Long id) {
		        Optional<Provider> providerOptional = providerRepository.findById(id);
		        return providerOptional.orElse(null);
		    }
	}

