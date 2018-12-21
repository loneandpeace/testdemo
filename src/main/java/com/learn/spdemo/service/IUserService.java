package com.learn.spdemo.service;

import com.learn.spdemo.entity.AppUser;

import java.util.List;

public interface IUserService {
    public List<AppUser> findAll();

    public void saveUser(AppUser user1);

    public AppUser findOne(long id);

    public void delete(long id);

    public List<AppUser> findByName(String name);
}
