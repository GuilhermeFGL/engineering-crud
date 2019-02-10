package com.guilhermefgl.crudsellerclient.util.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

import com.guilhermefgl.crudsellerclient.controller.dto.ClientDto;
import com.guilhermefgl.crudsellerclient.controller.dto.SellerDto;
import com.guilhermefgl.crudsellerclient.model.Client;
import com.guilhermefgl.crudsellerclient.model.Seller;

public class SellerMapperTest {

	@Test
	public void testToModel() {
		ClientDto clientDto = new ClientDto();
		clientDto.setId(1l);

		SellerDto sellerDto = new SellerDto();
		sellerDto.setId(2l);
		sellerDto.setName("name");
		sellerDto.setCpf("cpf");

		sellerDto.setClients(new ArrayList<ClientDto>());
		sellerDto.getClients().add(clientDto);

		Seller seller = SellerMapper.toModel(sellerDto);
		assertNotNull(seller);
		assertEquals(sellerDto.getId(), seller.getId());
		assertEquals(sellerDto.getName(), seller.getName());
		assertEquals(sellerDto.getCpf(), seller.getCpf());
		assertNotNull(seller.getClients());
		assertFalse(seller.getClients().isEmpty());

		Client client = seller.getClients().iterator().next();
		assertNotNull(client);
		assertEquals(clientDto.getName(), client.getName());
	}

	@Test
	public void testToDto() {
		Client client = new Client();
		client.setId(1l);

		Seller seller = new Seller();
		seller.setId(2l);
		seller.setName("name");
		seller.setCpf("cpf");

		seller.setClients(new HashSet<Client>());
		seller.getClients().add(client);

		SellerDto sellerDto = SellerMapper.toDto(seller);
		assertNotNull(sellerDto);
		assertEquals(seller.getId(), sellerDto.getId());
		assertEquals(seller.getName(), sellerDto.getName());
		assertEquals(seller.getCpf(), sellerDto.getCpf());
		assertNotNull(sellerDto.getClients());
		assertFalse(sellerDto.getClients().isEmpty());
		assertNotNull(sellerDto.getClients().get(0));
		assertEquals(client.getName(), sellerDto.getClients().get(0).getName());
	}

}
