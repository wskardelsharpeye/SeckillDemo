package com.example.service;

import com.example.entity.Role;
import com.example.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService {

    @Autowired
    RoleMapper roleMapper;

    public Role select(int id){
        return roleMapper.select(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Role r) {
        r.setRole("admin");
        roleMapper.save(r);
       // throw new RuntimeException("failed insert role");
    }

}
