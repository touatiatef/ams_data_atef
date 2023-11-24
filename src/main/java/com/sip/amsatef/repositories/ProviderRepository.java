package com.sip.amsatef.repositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sip.amsatef.entities.Provider;

@Repository
public interface ProviderRepository extends CrudRepository<Provider, Long> {

}
