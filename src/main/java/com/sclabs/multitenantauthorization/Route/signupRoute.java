package com.sclabs.multitenantauthorization.Route;

import com.sclabs.multitenantauthorization.Config.MultitenantMongo;
import com.sclabs.multitenantauthorization.Controller.signupController;
import com.sclabs.multitenantauthorization.Model.loginSignupModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class signupRoute {

    @Autowired
    signupController control;
    
    @Autowired
	MongoTemplate mongoTemplate;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@RequestBody loginSignupModel modeluser) {
        // ModelAndView modelAndView = new ModelAndView();
        // userService.loadUserByUsername(String email);
        // modelAndView.addObject("user", user);
        // modelAndView.setViewName("signup");
        return "Result:" + control.finduser(modeluser.getEmail(), modeluser.getUserid(), modeluser.getPassword(),
                modeluser.getUserType(), modeluser.getCompanyname());
    }
    
    @RequestMapping(value="/testing",method=RequestMethod.POST)
	@ResponseBody
	public String signup(@RequestHeader("servicename") String servicename, @RequestHeader("dbname") String dbname, @RequestHeader("username") String username, @RequestHeader("password") String password) {
		System.out.println("***** Executing Test cases on DB: " + mongoTemplate.getDb().getName() + ", *****");
		MultitenantMongo.setDatabaseNameForCurrentThread(dbname);
		MultitenantMongo.clearDatabaseNameForCurrentThread();
		System.out.println("***** Executing Test cases on DB: " + mongoTemplate.getDb().getName() + ", *****");
		return "\nRequest comming for Tenant: "+ dbname +"\nproduct Service : "+servicename + "\nusername: "+ username + " "
				+ "\npassword:" + password;
	}

    

}
