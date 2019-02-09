package com.guilhermefgl.crudsellerclient.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilhermefgl.crudsellerclient.model.Client;
import com.guilhermefgl.crudsellerclient.service.dao.ClientDao;
import com.guilhermefgl.crudsellerclient.service.repository.ClientRepository;

@Service
public class ClientService implements ClientDao {

	@Autowired
	private ClientRepository repository;

	@Override
	public Optional<Client> find(Long id) {
		return repository.findById(id);
	}

	@Override
	public Client save(Client client) {
		return repository.save(client);
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
			return !repository.findByName(client.getName()).isPresent();
		}
		return !repository.findByNameAndIdNot(client.getName(), client.getId()).isPresent();
	}

}
