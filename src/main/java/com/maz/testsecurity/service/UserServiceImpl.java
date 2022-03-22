package com.maz.testsecurity.service;

import com.maz.testsecurity.domain.Role;
import com.maz.testsecurity.domain.User;
import com.maz.testsecurity.repository.RoleRepository;
import com.maz.testsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.saveAndFlush(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.saveAndFlush(role);
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username).orElseThrow(RuntimeException::new);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {

        User user = userRepository.findByUsername(username).orElseThrow(RuntimeException::new);
        Role role = roleRepository.findByName(roleName);

        user.getRoles().add(role);
        userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

}
