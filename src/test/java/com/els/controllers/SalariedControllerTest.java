package com.els.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.els.entities.Salaried;
import com.els.services.SalariedService;

@RunWith(MockitoJUnitRunner.class)
public class SalariedControllerTest {

	@Mock
	SalariedService salariedService;

	@InjectMocks
	SalariedController salariedController;

	private MockMvc restUserMockMvc;

	@Before
	public void setup() {
		this.restUserMockMvc = MockMvcBuilders.standaloneSetup(salariedController).build();
	}

	@Test
	public void testDistinctSalariesByAttribute() throws Exception {

		// given
		Salaried salaried = new Salaried("1", "1", "Alex", "Brown", "0600000000");
		List<Salaried> salarieds = Arrays.asList(salaried);

		// when
		when(salariedService.distinctSalariesByAttribute(Mockito.anyString())).thenReturn(salarieds);

		// then
		restUserMockMvc.perform(get("/api/salaries?attribute=firstName")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8")).andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].salariedId", is("1"))).andExpect(jsonPath("$[0].firstName", is("Alex")));
		// verify
		verify(salariedService, times(1)).distinctSalariesByAttribute(Mockito.anyString());
		verifyNoMoreInteractions(salariedService);
	}

}
