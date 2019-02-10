package com.guilhermefgl.crudsellerclient.service.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.guilhermefgl.crudsellerclient.model.Client;
import com.guilhermefgl.crudsellerclient.model.Seller;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientRepositoryTest {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private SellerRepository sellerRepository;

	@Before
	public void setUp() throws Exception {
		Client client1 = new Client();
		client1.setName("client1");
		client1.setCpf("cpf1");
		clientRepository.save(client1);

		Seller seller1 = new Seller();
		seller1.setName("seller1");
		seller1.setCpf("cpf2");
		seller1 = sellerRepository.save(seller1);

		Client client2 = new Client();
		client2.setName("client2");
		client2.setCpf("cpf3");
		client2.setSeller(seller1);
		clientRepository.save(client2);
	}

	@Test
	public void testFindAll() {
		List<Client> clients = clientRepository.findAll();
		assertNotNull(clients);
		assertFalse(clients.isEmpty());
		assertEquals(2, clients.size());
	}

	@Test
	public void testListClientAndSeller() {
		List<Client> clients = clientRepository.listClientAndSeller();
		assertNotNull(clients);
		assertFalse(clients.isEmpty());
		assertEquals(1, clients.size());
	}

	@Test
	public void testListClientBySellerId() {
		List<Seller> sellers = sellerRepository.findAll();

		List<Client> clients = clientRepository.listClientBySellerId(sellers.get(0).getId());
		assertNotNull(clients);
		assertFalse(clients.isEmpty());
		assertEquals(1, clients.size());
	}

	@After
	public final void tearDown() {
		clientRepository.deleteAll();
		sellerRepository.deleteAll();
	}

}
