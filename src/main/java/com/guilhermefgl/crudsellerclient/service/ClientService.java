package com.guilhermefgl.crudsellerclient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilhermefgl.crudsellerclient.model.Client;
import com.guilhermefgl.crudsellerclient.repository.ClientRepository;
import com.guilhermefgl.crudsellerclient.service.dao.ClientDao;

@Service
public class ClientService implements ClientDao {

	@Autowired
	private ClientRepository repository;

	@Override
	public void save(Client client) {
		repository.save(client);
	}

	@Override
	public void delete(Client client) {
		repository.delete(client);
	}

	@Override
	public List<Client> listClientAndSeller() {
		return repository.listClientAndSeller();
	}

	@Override
	public List<Client> listClientBySellerId(Long sellerId) {
		return repository.listClientBySellerId(sellerId);
	}

	@Override
	public boolean isNameUniq(Client client) {
		if (client.getId() == null) {
			return repository.findByName(client.getName()) == null;
		}
		return repository.findByNameAndIdNot(client.getName(), client.getId()) == null;
	}

}
