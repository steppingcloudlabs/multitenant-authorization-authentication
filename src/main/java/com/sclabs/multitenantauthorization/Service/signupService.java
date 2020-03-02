
package com.sclabs.multitenantauthorization.Service;

import java.util.List;

import com.sclabs.multitenantauthorization.Model.Users;
import com.sclabs.multitenantauthorization.Repository.AuthRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.stereotype.Service;

@Service
public class signupService {

    private final MongoTemplate mongoTemplate;

    public signupService(MongoTemplate mongoTemplate) {
        super();
        this.mongoTemplate = mongoTemplate;

    }

    public List<Users> finduser(String email, String userid, String password, String usertype,
            String companyname) {
        Query query = new Query().addCriteria(Criteria.where("email").is(email));
        return mongoTemplate.find(query, Users.class);

    }
}