package com.sclabs.multitenantauthorization.Repository;

import com.sclabs.multitenantauthorization.Model.Users;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends MongoRepository<Users, String> , CustomAuthRepository{

}