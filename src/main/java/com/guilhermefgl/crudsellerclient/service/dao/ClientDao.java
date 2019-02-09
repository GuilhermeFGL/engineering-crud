package com.guilhermefgl.crudsellerclient.service.dao;

import java.util.List;
import java.util.Optional;

import com.guilhermefgl.crudsellerclient.model.Client;

public interface ClientDao {

	Optional<Client> find(Long id);

	Client save(Client client);

	void delete(Client client);

	List<Client> listClientAndSeller();

	List<Client> listClientBySellerId(Long sellerId);

	boolean isNameUniq(Client client);

}
