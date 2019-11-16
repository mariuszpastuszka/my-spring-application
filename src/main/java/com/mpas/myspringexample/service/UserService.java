package com.mpas.myspringexample.service;

import com.mpas.myspringexample.domain.User;
import com.mpas.myspringexample.repository.UserAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    private UserAccess userRepostitory;

    @Autowired
    public UserService(UserAccess userRepostitory) {
        this.userRepostitory = userRepostitory;
    }

    public List<User> getAllUsers() {
        return userRepostitory.readAllUsers();
    }
}
