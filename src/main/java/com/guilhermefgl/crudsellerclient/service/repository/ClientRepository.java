package com.guilhermefgl.crudsellerclient.service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.guilhermefgl.crudsellerclient.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	@Query("SELECT c FROM Client c JOIN FETCH c.seller s")
	List<Client> listClientAndSeller();

	@Query("SELECT c FROM Client c JOIN FETCH c.seller s WHERE s.id = ?1")
	List<Client> listClientBySellerId(Long sellerId);

	Optional<Client> findByName(String name);

	Optional<Client> findByNameAndIdNot(String name, Long id);

}
