package com.sclabs.multitenantauthorization.Route;

import com.sclabs.multitenantauthorization.Controller.loginSignupController;
import com.sclabs.multitenantauthorization.Model.loginSignupModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loginRoute {

    @Autowired
    loginSignupController control;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@RequestBody loginSignupModel modeluser) {
        // ModelAndView modelAndView = new ModelAndView();
        // userService.loadUserByUsername(String email);
        // modelAndView.addObject("user", user);
        // modelAndView.setViewName("signup");
        return "result=" + control.finduser(modeluser.getEmail());
    }

}
