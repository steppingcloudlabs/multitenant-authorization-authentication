package com.sclabs.multitenantauthorization.Controller;

import java.util.List;

import com.sclabs.multitenantauthorization.Model.loginSignupModel;
import com.sclabs.multitenantauthorization.Service.loginSignupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class loginSignupController {
    @Autowired
    private loginSignupService userService;

    public List<loginSignupModel> finduser(String email) {
        System.out.println(email);
        /**
         * 
         */
        List<loginSignupModel> tenant = userService.finduser(email);
        return tenant;
    };

}