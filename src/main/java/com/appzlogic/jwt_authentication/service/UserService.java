package com.appzlogic.jwt_authentication.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.appzlogic.jwt_authentication.entities.Userdb;
import com.appzlogic.jwt_authentication.repo.UserdbRepo;

@Service
public class UserService {
    @Autowired
    private UserdbRepo userdbRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Userdb> getUsers() {
        return userdbRepo.findAll();
    }

    public Userdb createUser(Userdb userdb) {
        // generate uuid random id
        userdb.setUserId(UUID.randomUUID().toString());
        userdb.setPassword(passwordEncoder.encode(userdb.getPassword()));
        return userdbRepo.save(userdb);

    }

}
