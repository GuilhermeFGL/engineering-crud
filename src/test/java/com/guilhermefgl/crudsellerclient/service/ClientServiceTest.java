package com.guilhermefgl.crudsellerclient.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.guilhermefgl.crudsellerclient.model.Client;
import com.guilhermefgl.crudsellerclient.service.repository.ClientRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceTest {

	@MockBean
	private ClientRepository repository;

	@Autowired
	private ClientService service;

	@Before
	public void setUp() {
		BDDMockito.given(repository.findById(Mockito.anyLong())).willReturn(Optional.of(new Client()));
		BDDMockito.given(repository.save(Mockito.any(Client.class))).willReturn(new Client());
		BDDMockito.given(repository.findAll()).willReturn(new ArrayList<Client>());
		BDDMockito.given(repository.listClientBySellerId(Mockito.anyLong())).willReturn(new ArrayList<Client>());
		BDDMockito.given(repository.findByName(Mockito.anyString())).willReturn(Optional.of(new Client()));
		BDDMockito.given(repository.findByNameAndIdNot(Mockito.anyString(), Mockito.anyLong()))
				.willReturn(Optional.of(new Client()));
	}

	@Test
	public void testFind() {
		Optional<Client> client = service.find(1l);
		assertTrue(client.isPresent());
		assertNotNull(client.get());
	}

	@Test
	public void testSave() {
		Client client = service.save(new Client());
		assertNotNull(client);
	}

	@Test
	public void testDelete() {
		service.delete(new Client());
	}

	@Test
	public void testList() {
		List<Client> clients = service.list();
		assertNotNull(clients);
	}

	@Test
	public void testListClientAndSeller() {
		List<Client> clients = service.listClientAndSeller();
		assertNotNull(clients);
	}

	@Test
	public void testListClientBySellerId() {
		List<Client> clients = service.listClientBySellerId(1l);
		assertNotNull(clients);
	}

	@Test
	public void testIsNameUniqInsert() {
		assertTrue(service.isNameUniq(new Client()));
	}

	@Test
	public void testIsNameUniqUpdate() {
		Client client = new Client();
		client.setId(1l);
		assertTrue(service.isNameUniq(client));
	}

}
