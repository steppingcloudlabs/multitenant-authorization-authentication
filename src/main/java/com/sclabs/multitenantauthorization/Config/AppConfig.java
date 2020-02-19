package com.sclabs.multitenantauthorization.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class AppConfig{
	@Bean
	public MongoClient mongoClient() {
		return MongoClients.create("mongodb://localhost:27017");
	}
	
	@Bean
	public MongoTemplate mongoTemplate(com.mongodb.client.MongoClient mongoClient) throws Exception {
		return new MongoTemplate(mongoDbFactory(mongoClient));
	}

	@Bean
	public MultitenantMongo mongoDbFactory(com.mongodb.client.MongoClient mongo) throws Exception {
		return new MultitenantMongo(mongo, "steppingcloud");
	}
	
	
}
