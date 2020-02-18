package com.sclabs.multitenantauthorization.Route;

import com.sclabs.multitenantauthorization.Controller.loginController;
import com.sclabs.multitenantauthorization.Model.loginSignupModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loginRoute {

    @Autowired
    loginController control;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody loginSignupModel modeluser) {
        // ModelAndView modelAndView = new ModelAndView();
        // userService.loadUserByUsername(String email);
        // modelAndView.addObject("user", user);
        // modelAndView.setViewName("signup");
        return "Result:" + control.finduser(modeluser.getEmail());
    }

}
