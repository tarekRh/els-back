package com.els.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.els.entities.Salaried;

@Repository
public interface SalariedRepository extends MongoRepository<Salaried, String> {

}
