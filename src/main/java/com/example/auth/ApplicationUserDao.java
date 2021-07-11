package com.example.auth;

import java.util.Optional;

public interface ApplicationUserDao {

    Optional<CustomUserDetails> selectApplicationUserByUsername(String username);

}

