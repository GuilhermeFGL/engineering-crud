package com.guilhermefgl.crudsellerclient.util.mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.guilhermefgl.crudsellerclient.controller.dto.ClientDto;
import com.guilhermefgl.crudsellerclient.controller.dto.SellerDto;
import com.guilhermefgl.crudsellerclient.model.Client;
import com.guilhermefgl.crudsellerclient.model.Seller;

public final class SellerMapper {

	private SellerMapper() {
	}

	public static Seller toModel(SellerDto sellerDto) {
		if (sellerDto == null) {
			return null;
		}

		Seller seller = new Seller();
		seller.setId(sellerDto.getId());
		seller.setName(sellerDto.getName());
		seller.setCpf(sellerDto.getCpf());

		Set<Client> clients = sellerDto.getClients().stream().map(c -> {
			Client client = new Client();
			client.setId(c.getId());
			client.setName(c.getName());
			client.setGender(c.getGender());
			client.setCpf(c.getCpf());
			return client;
		}).collect(Collectors.toSet());
		seller.setClients(clients);

		return seller;
	}

	public static SellerDto toDto(Seller seller) {
		if (seller == null) {
			return null;
		}

		SellerDto sellerDto = new SellerDto();
		sellerDto.setId(seller.getId());
		sellerDto.setName(seller.getName());
		sellerDto.setCpf(seller.getCpf());

		List<ClientDto> clientsDto = seller.getClients().stream().map(c -> {
			ClientDto clientDto = new ClientDto();
			clientDto.setId(c.getId());
			clientDto.setName(c.getName());
			clientDto.setGender(c.getGender());
			clientDto.setCpf(c.getCpf());
			return clientDto;
		}).collect(Collectors.toList());
		sellerDto.setClients(clientsDto);

		return sellerDto;
	}

}
