package com.guilhermefgl.crudsellerclient.util.mapper;

import com.guilhermefgl.crudsellerclient.controller.dto.ClientDto;
import com.guilhermefgl.crudsellerclient.controller.dto.SellerDto;
import com.guilhermefgl.crudsellerclient.model.Client;
import com.guilhermefgl.crudsellerclient.model.Seller;

public class ClientMapper {

	private ClientMapper() {
	}

	public static Client toModel(ClientDto clientDto) {
		if (clientDto == null) {
			return null;
		}

		Client client = new Client();
		client.setId(clientDto.getId());
		client.setName(clientDto.getName());
		client.setCpf(clientDto.getCpf());
		client.setGender(clientDto.getGender());

		if (clientDto.getSeller() != null) {
			Seller seller = new Seller();
			seller.setId(clientDto.getSeller().getId());
			client.setSeller(seller);
		}

		return client;
	}

	public static ClientDto toDto(Client client) {
		if (client == null) {
			return null;
		}

		ClientDto clientDto = new ClientDto();
		clientDto.setId(client.getId());
		clientDto.setName(client.getName());
		clientDto.setCpf(client.getCpf());
		clientDto.setGender(client.getGender());

		if (client.getSeller() != null) {
			SellerDto sellerDto = new SellerDto();
			sellerDto.setName(client.getSeller().getName());
			clientDto.setSeller(sellerDto);
		}

		return clientDto;
	}

}
