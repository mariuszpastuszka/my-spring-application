package com.mpas.myspringexample.repository;

import com.mpas.myspringexample.domain.User;

import java.util.List;

public interface UserAccess {
    List<User> readAllUsers();
}
