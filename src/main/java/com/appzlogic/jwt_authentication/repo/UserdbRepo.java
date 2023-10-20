package com.appzlogic.jwt_authentication.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appzlogic.jwt_authentication.entities.Userdb;

public interface UserdbRepo extends JpaRepository<Userdb, String> {
    public Optional<Userdb> findByEmail(String email);

}
