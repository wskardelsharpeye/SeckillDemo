package com.example.service;

import com.example.entity.Role;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignUpService {

    @Autowired
    public SignUpService(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    private UserService userService;

    private RoleService roleService;

    @Transactional
    public int createUsers() {

        Role r = new Role();
        r.setRole("r");
        roleService.save(r);

        User u = new User();
        u.setUsername("u");
        u.setPassword("p");
        userService.save(u);





        return 1;
    }

}
