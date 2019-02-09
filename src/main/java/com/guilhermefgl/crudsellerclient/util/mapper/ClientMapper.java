package com.guilhermefgl.crudsellerclient.util.mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

		Set<Seller> sellers = clientDto.getSellers().stream().map(s -> {
			Seller seller = new Seller();
			seller.setId(s.getId());
			seller.setName(s.getName());
			seller.setCpf(s.getCpf());
			return seller;
		}).collect(Collectors.toSet());
		client.setSellers(sellers);

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

		List<SellerDto> sellersDto = client.getSellers().stream().map(s -> {
			SellerDto sellerDto = new SellerDto();
			sellerDto.setName(s.getName());
			return sellerDto;
		}).collect(Collectors.toList());
		clientDto.setSellers(sellersDto);

		return clientDto;
	}

}
