package com.guilhermefgl.crudsellerclient.service;

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
	public void save(Seller seller) {
		repository.save(seller);
	}

	@Override
	public void delete(Seller seller) {
		repository.delete(seller);
	}

	@Override
	public boolean isNameUniq(Seller seller) {
		if (seller.getId() == null) {
			return repository.findByName(seller.getName()) == null;
		}
		return repository.findByNameAndIdNot(seller.getName(), seller.getId()) == null;
	}

}
