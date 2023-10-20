package com.appzlogic.jwt_authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.appzlogic.jwt_authentication.entities.Userdb;
import com.appzlogic.jwt_authentication.repo.UserdbRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserdbRepo userdbRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Userdb user = userdbRepo.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found!!"));
        return user;
    }

}
