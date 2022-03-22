package com.maz.testsecurity.service;

import com.maz.testsecurity.domain.Role;
import com.maz.testsecurity.domain.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    Role saveRole(Role role);

    User getUser(String username);

    void addRoleToUser(String username, String roleName);

    List<User> getUsers();

}
