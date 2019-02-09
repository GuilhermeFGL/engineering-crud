package com.guilhermefgl.crudsellerclient.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilhermefgl.crudsellerclient.model.Seller;
import com.guilhermefgl.crudsellerclient.repository.SellerRepository;
import com.guilhermefgl.crudsellerclient.service.dao.SellerDao;

@Service
public class SellerService implements SellerDao {

	@Autowired
	private SellerRepository repository;

	@Override
	public List<Seller> list() {
		return repository.findAll();
	}

	@Override
	public Optional<Seller> find(Long id) {
		return repository.findById(id);
	}

	@Override
	public Seller save(Seller seller) {
		return repository.save(seller);
	}

	@Override
	public void delete(Seller seller) {
		repository.delete(seller);
	}

	@Override
	public boolean isNameUniq(Seller seller) {
		if (seller.getId() == null) {
			return !repository.findByName(seller.getName()).isPresent();
		}
		return !repository.findByNameAndIdNot(seller.getName(), seller.getId()).isPresent();
	}

}
