package com.sclabs.multitenantauthorization.Repository;

import com.sclabs.multitenantauthorization.Model.loginSignupModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface loginSignupRepository extends MongoRepository<loginSignupModel, String> {

    // loginSignupModel findbyEmail(String email);

    // loginSignupModel findbyUserid(String userid);

}