package com.example.mapper;


import com.example.entity.Role;
import com.example.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper {

    Role select(Integer id);

    int save(Role r);

}
