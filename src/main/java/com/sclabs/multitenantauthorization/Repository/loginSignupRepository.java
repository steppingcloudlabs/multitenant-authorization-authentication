package com.sclabs.multitenantauthorization.Repository;

import com.sclabs.multitenantauthorization.Model.loginSignupModel;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface loginSignupRepository extends MongoRepository<loginSignupModel, String> {

}