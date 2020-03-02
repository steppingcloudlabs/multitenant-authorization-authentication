package com.sclabs.multitenantauthorization.Controller;

import java.util.List;

import com.sclabs.multitenantauthorization.Model.Users;
import com.sclabs.multitenantauthorization.Service.signupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class signupController {
    @Autowired
    private signupService userService;

    public List<Users> finduser(String email, String userid, String password, String usertype,
            String companyname) {

        List<Users> foundresult = userService.finduser(email, userid, password, usertype, companyname);
        return foundresult;
    };

}