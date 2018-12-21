package com.learn.spdemo.service.impl;

import com.learn.spdemo.entity.AppUser;
import com.learn.spdemo.repository.User1Repository;
import com.learn.spdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Transactional
public class UserServiceImpl implements IUserService {


    @Autowired
    public User1Repository userRepository;


    @Override
    public List<AppUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(AppUser user1) {
        userRepository.save(user1);
    }

    @Override
    public AppUser findOne(long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<AppUser> findByName(String name) {
        return null;
    }

}
