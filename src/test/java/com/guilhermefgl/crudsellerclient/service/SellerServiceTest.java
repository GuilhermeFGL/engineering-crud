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

import com.guilhermefgl.crudsellerclient.model.Seller;
import com.guilhermefgl.crudsellerclient.service.repository.SellerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerServiceTest {

	@MockBean
	private SellerRepository repository;

	@Autowired
	private SellerService service;

	@Before
	public void setUp() {
		BDDMockito.given(repository.findById(Mockito.anyLong())).willReturn(Optional.of(new Seller()));
		BDDMockito.given(repository.save(Mockito.any(Seller.class))).willReturn(new Seller());
		BDDMockito.given(repository.findAll()).willReturn(new ArrayList<Seller>());
		BDDMockito.given(repository.findByName(Mockito.anyString())).willReturn(Optional.of(new Seller()));
		BDDMockito.given(repository.findByNameAndIdNot(Mockito.anyString(), Mockito.anyLong()))
				.willReturn(Optional.of(new Seller()));
	}

	@Test
	public void testFind() {
		Optional<Seller> seller = service.find(1l);
		assertTrue(seller.isPresent());
		assertNotNull(seller.get());
	}

	@Test
	public void testSave() {
		Seller seller = service.save(new Seller());
		assertNotNull(seller);
	}

	@Test
	public void testDelete() {
		service.delete(new Seller());
	}

	@Test
	public void testList() {
		List<Seller> sellers = service.list();
		assertNotNull(sellers);
	}

	@Test
	public void testIsNameUniqInsert() {
		assertTrue(service.isNameUniq(new Seller()));
	}

	@Test
	public void testIsNameUniqUpdate() {
		Seller seller = new Seller();
		seller.setId(1l);
		assertTrue(service.isNameUniq(seller));
	}

}
