package com.els.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configurable
@EnableMongoRepositories("com.els.repositories")
@Import(value = MongoAutoConfiguration.class)
public class DatabaseConfiguration {
}