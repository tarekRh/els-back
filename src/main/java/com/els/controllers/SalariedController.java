package com.els.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.els.entities.Salaried;
import com.els.services.SalariedService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class SalariedController {

	private final Logger log = LoggerFactory.getLogger(SalariedController.class);

	@Autowired
	SalariedService salariedService;

	/**
	 * GET /salaries : get distinct salaries by attribute.
	 * 
	 * @param attribute
	 *            the filter
	 * @return ResponseEntity with the list of salaries distinct by attribute
	 */
	@GetMapping("/salaries")
	public ResponseEntity<List<Salaried>> distinctSalariesByAttribute(@RequestParam("attribute") String attribute) {
		log.debug("find list of salaries distinct by attribute: {}", attribute);
		return new ResponseEntity<>(salariedService.distinctSalariesByAttribute(attribute), HttpStatus.OK);
	}

}
