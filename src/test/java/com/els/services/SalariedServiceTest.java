package com.els.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.els.entities.Salaried;
import com.els.repositories.SalariedRepository;
import com.els.services.impl.SalariedServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class SalariedServiceTest {

	@Mock
	private SalariedRepository salariedRepository;

	@InjectMocks
	private SalariedServiceImpl salariedServiceImpl;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testDistinctSalariesByFirstName() {
		// given
		Salaried salaried1 = new Salaried("1", "1", "Jean", "francois", "0600000000");
		Salaried salaried2 = new Salaried("2", "2", "Jean", "burg", "0600000001");
		Salaried salaried3 = new Salaried("3", "3", "Camille", "francois", "0600000001");
		List<Salaried> salarieds = Arrays.asList(salaried1, salaried2, salaried3);

		// when
		when(salariedRepository.findAll()).thenReturn(salarieds);

		// when

		List<Salaried> returnedList = salariedServiceImpl.distinctSalariesByAttribute("firstName");

		// assert
		assertThat(returnedList).isNotEmpty();
		assertThat(returnedList).hasSize(2);
	}

	@Test
	public void testDistinctSalariesByLastName() {
		// given
		Salaried salaried1 = new Salaried("1", "1", "Jean", "francois", "0600000000");
		Salaried salaried2 = new Salaried("2", "2", "Alex", "francois", "0600000001");
		Salaried salaried3 = new Salaried("3", "3", "Camille", "francois", "0600000001");
		List<Salaried> salarieds = Arrays.asList(salaried1, salaried2, salaried3);

		// when
		when(salariedRepository.findAll()).thenReturn(salarieds);

		// when

		List<Salaried> returnedList = salariedServiceImpl.distinctSalariesByAttribute("lastName");

		// assert
		assertThat(returnedList).isNotEmpty();
		assertThat(returnedList).hasSize(1);
	}

	@Test
	public void testDistinctSalariesByTel() {
		// given
		Salaried salaried1 = new Salaried("1", "1", "Jean", "francois", "0600000000");
		Salaried salaried2 = new Salaried("2", "2", "Alex", "francois", "0600000001");
		Salaried salaried3 = new Salaried("3", "3", "Camille", "francois", "0600000001");
		List<Salaried> salarieds = Arrays.asList(salaried1, salaried2, salaried3);

		// when
		when(salariedRepository.findAll()).thenReturn(salarieds);

		// when

		List<Salaried> returnedList = salariedServiceImpl.distinctSalariesByAttribute("tel");

		// assert
		assertThat(returnedList).isNotEmpty();
		assertThat(returnedList).hasSize(2);
	}
}
