package com.els.services.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.els.entities.Salaried;
import com.els.repositories.SalariedRepository;
import com.els.services.SalariedService;
import com.els.utils.Utils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class SalariedServiceImpl implements SalariedService {

	private final Logger log = LoggerFactory.getLogger(SalariedServiceImpl.class);
	@Value("${input.file.path}")
	private String inputFilePath;

	@Autowired
	SalariedRepository salariedRepository;

	@PostConstruct
	public void init() {
		log.debug("Start importing salarieds input file");
		// Delete all data from Database to insert a new data (in case of input file
		// changes)
		salariedRepository.deleteAll();
		ObjectMapper mapper = new ObjectMapper();
		TypeReference<List<Salaried>> typeReference = new TypeReference<List<Salaried>>() {
		};
		InputStream inputStream = TypeReference.class.getResourceAsStream(inputFilePath);
		try {
			List<Salaried> salaries = mapper.readValue(inputStream, typeReference);
			salariedRepository.save(salaries);
		} catch (IOException e) {
			log.error("Unable to save salaries: {}", e.getMessage());
		}
		log.debug("Import Success");
	}

	/**
	 * distinctSalariesByAttribute : find distinct salaried by attribute
	 * 
	 * @param attribute
	 *            (String) : the filter
	 * @return the list of salaried fetched
	 */
	@Override
	public List<Salaried> distinctSalariesByAttribute(String attribute) {
		log.debug("get distinct salaries by attribute {}", attribute);
		List<Salaried> salarieds = salariedRepository.findAll();
		if (!salarieds.isEmpty()) {
			return salarieds.stream()
					.filter(Utils.distinctByKey(salaried -> Utils.fetchSalariedProperty(salaried, attribute)))
					.collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

}
