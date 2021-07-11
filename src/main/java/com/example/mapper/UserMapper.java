package com.example.mapper;


import com.example.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User findByName(String username);

    User select(int id);

    void save(User user);

    void update(User user);

    void delete(int i);

}
