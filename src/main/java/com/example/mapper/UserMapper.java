package com.example.mapper;


import com.example.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {

    User findByName(String username);

    User select(int id);

    void save(User user);

    void update(User user);

    void delete(int i);

    List<User> findUsersByPage(Map<String, Object> params);

}
