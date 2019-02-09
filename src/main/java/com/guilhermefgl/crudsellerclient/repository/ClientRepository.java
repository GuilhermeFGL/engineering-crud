package com.guilhermefgl.crudsellerclient.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.guilhermefgl.crudsellerclient.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	@Query("SELECT c, s.id FROM Client c LEFT JOIN FETCH Seller s")
	List<Client> listClientAndSeller();

	@Query("SELECT c, s.id FROM Client c LEFT JOIN FETCH Seller s WHERE s.id = ?1")
	List<Client> listClientBySellerId(Long sellerId);

	Optional<Client> findByName(String name);

	Optional<Client> findByNameAndIdNot(String name, Long id);

}
