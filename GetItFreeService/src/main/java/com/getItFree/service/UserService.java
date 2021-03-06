package com.getItFree.service;

import com.getItFree.model.User;

import java.math.BigInteger;
import java.util.List;

public interface UserService {

    void resetCredentials();

    User findById(BigInteger id);

    User findByUsername(String username);

    List<User> findAll();

    User save(User user);
}
