package com.guilhermefgl.crudsellerclient.service.dao;

import java.util.List;

import com.guilhermefgl.crudsellerclient.model.Client;

public interface ClientDao {

	void save(Client client);

	void delete(Client client);

	List<Client> listClientAndSeller();

	List<Client> listClientBySellerId(Long sellerId);

	boolean isNameUniq(Client client);

}
