package com.guilhermefgl.crudsellerclient.service.dao;

import com.guilhermefgl.crudsellerclient.model.Seller;

public interface SellerDao {

	void save(Seller seller);

	void delete(Seller seller);

	boolean isNameUniq(Seller seller);

}
