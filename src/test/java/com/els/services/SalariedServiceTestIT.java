package com.els.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.els.entities.Salaried;
import com.els.repositories.SalariedRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SalariedServiceTestIT {

	@Autowired
	private SalariedRepository salariedRepository;


	@Test
	public void testInit() {
		
		List<Salaried> returnedList = salariedRepository.findAll();

		// assert
		assertThat(returnedList).isNotEmpty();
		assertThat(returnedList).hasSize(8);
	}

}
