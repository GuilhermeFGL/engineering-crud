package com.guilhermefgl.crudsellerclient.service.dao;

import java.util.List;
import java.util.Optional;

import com.guilhermefgl.crudsellerclient.model.Seller;

public interface SellerDao {

	List<Seller> list();

	Optional<Seller> find(Long id);

	Seller save(Seller seller);

	void delete(Seller seller);

	boolean isNameUniq(Seller seller);

}
