package com.guilhermefgl.crudsellerclient.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.guilhermefgl.crudsellerclient.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	@Query("SELECT c, s.id FROM Client c LEFT JOIN FETCH Seller s")
	List<Client> listClientAndSeller();

	@Query("SELECT c, s.id FROM Client c LEFT JOIN FETCH Seller s WHERE s.id = ?1")
	List<Client> listClientBySellerId(Long sellerId);

	Client findByName(String name);

	Client findByNameAndIdNot(String name, Long id);

}
