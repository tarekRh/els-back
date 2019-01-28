package com.els.services;

import java.util.List;

import com.els.entities.Salaried;


public interface SalariedService {

	List<Salaried> distinctSalariesByAttribute(String attribute);

}
