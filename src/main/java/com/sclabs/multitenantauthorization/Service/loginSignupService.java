
package com.sclabs.multitenantauthorization.Service;

import java.util.List;

import com.sclabs.multitenantauthorization.Model.loginSignupModel;
import com.sclabs.multitenantauthorization.Repository.loginSignupRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class loginSignupService {

    // @Autowired
    // private loginSignupRepository loginRepository;
    // @Autowired
    // private BCryptPasswordEncoder bCryptPasswordEncoder;

    private final MongoTemplate mongoTemplate;

    public loginSignupService(MongoTemplate mongoTemplate) {
        super();
        this.mongoTemplate = mongoTemplate;

    }

    public List<loginSignupModel> finduser(String email) {
        Query query = new Query().addCriteria(Criteria.where("email").is(email));
        return mongoTemplate.find(query, loginSignupModel.class);
    }

    // @Bean
    // public BCryptPasswordEncoder passwordEncoder() {
    // BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    // return bCryptPasswordEncoder;
    // }

}