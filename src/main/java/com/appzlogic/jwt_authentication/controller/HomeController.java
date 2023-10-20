package com.appzlogic.jwt_authentication.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appzlogic.jwt_authentication.entities.Userdb;
import com.appzlogic.jwt_authentication.service.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<Userdb> getUser() {
        return this.userService.getUsers();
    }

    // principal -> yeh batayega current mein jo login hoga

    @GetMapping("/current-user")
    public String getCurrentLoggin(Principal principal) {
        return principal.getName();
    }

}
