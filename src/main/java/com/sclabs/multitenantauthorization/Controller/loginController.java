package com.sclabs.multitenantauthorization.Controller;

import java.util.List;

import com.sclabs.multitenantauthorization.Model.loginSignupModel;
import com.sclabs.multitenantauthorization.Service.loginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class loginController {
    @Autowired
    private loginService userService;

    public List<loginSignupModel> finduser(String email) {

        List<loginSignupModel> founduser = userService.finduser(email);
        return founduser;
    };

}