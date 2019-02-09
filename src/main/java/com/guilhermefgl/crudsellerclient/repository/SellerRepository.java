package com.guilhermefgl.crudsellerclient.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilhermefgl.crudsellerclient.model.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

	Optional<Seller> findByName(String name);

	Optional<Seller> findByNameAndIdNot(String name, Long id);

}
