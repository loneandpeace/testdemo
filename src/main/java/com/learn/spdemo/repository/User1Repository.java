package com.learn.spdemo.repository;

import com.learn.spdemo.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User1Repository extends JpaRepository<AppUser, Integer> {}
