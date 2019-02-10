package com.guilhermefgl.crudsellerclient.util.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.guilhermefgl.crudsellerclient.controller.dto.ClientDto;
import com.guilhermefgl.crudsellerclient.controller.dto.SellerDto;
import com.guilhermefgl.crudsellerclient.model.Client;
import com.guilhermefgl.crudsellerclient.model.Seller;
import com.guilhermefgl.crudsellerclient.model.enums.GenderEnum;

public class ClientMapperTest {

	@Test
	public void testToModel() {
		SellerDto sellerDto = new SellerDto();
		sellerDto.setId(1l);

		ClientDto clientDto = new ClientDto();
		clientDto.setId(2l);
		clientDto.setName("name");
		clientDto.setCpf("cpf");
		clientDto.setGender(GenderEnum.M);

		clientDto.setSeller(sellerDto);

		Client client = ClientMapper.toModel(clientDto);
		assertNotNull(client);
		assertEquals(clientDto.getId(), client.getId());
		assertEquals(clientDto.getName(), client.getName());
		assertEquals(clientDto.getCpf(), client.getCpf());
		assertEquals(clientDto.getGender(), client.getGender());
		assertNotNull(clientDto.getSeller());
		assertEquals(clientDto.getSeller().getId(), client.getSeller().getId());
	}

	@Test
	public void testToDto() {
		Seller seller = new Seller();
		seller.setName("seller");

		Client client = new Client();
		client.setId(2l);
		client.setName("name");
		client.setCpf("cpf");
		client.setGender(GenderEnum.M);

		client.setSeller(seller);

		ClientDto clientDto = ClientMapper.toDto(client);
		assertNotNull(client);
		assertEquals(client.getId(), clientDto.getId());
		assertEquals(client.getName(), clientDto.getName());
		assertEquals(client.getCpf(), clientDto.getCpf());
		assertEquals(client.getGender(), clientDto.getGender());
		assertNotNull(clientDto.getSeller());
		assertEquals(client.getSeller().getName(), clientDto.getSeller().getName());
	}

}
