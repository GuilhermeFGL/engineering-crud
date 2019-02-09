package com.guilhermefgl.crudsellerclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilhermefgl.crudsellerclient.model.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

	Seller findByName(String name);

}
