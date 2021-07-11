package com.example.auth;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.security.ApplicationUserRole.*;

@Repository("fake")
public class ApplicationUserDaoImpl implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Autowired
    public ApplicationUserDaoImpl(PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    public User select(int id) {
        return userMapper.select(id);
    }

    @Override
    public Optional<CustomUserDetails> selectApplicationUserByUsername(String username) {
        /*return getApplicationUsers().stream()
                .filter(user -> {
                    System.out.println(String.format("user.getUsername %s -- username : %s", user.getUsername(),username));
                    return user.getUsername().equals(username);
                })
                .findFirst();*/
        User aUser = userMapper.findByName(username);
        aUser.setPassword(passwordEncoder.encode(aUser.getPassword()));

        if (aUser != null) {
            CustomUserDetails customUserDetails = new CustomUserDetails(aUser);
            return Optional.of(customUserDetails);
        } else {
            return Optional.empty();
        }
    }
}
