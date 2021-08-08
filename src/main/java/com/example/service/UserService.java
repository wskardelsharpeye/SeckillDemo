package com.example.service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User select(int id){
        return userMapper.select(id);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(User user) {
        userMapper.save(user);
        throw new RuntimeException("failed insert user");
    }

    public void update(User user) {
        userMapper.update(user);
    }

    public void delete(int i) {
        userMapper.delete(i);
    }

    public List<User> findUsers(Map<String, Object> params) {
       return userMapper.findUsersByPage(params);
    }

}
