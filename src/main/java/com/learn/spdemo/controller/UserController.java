package com.learn.spdemo.controller;

import com.learn.spdemo.entity.AppUser;
import com.learn.spdemo.repository.User1Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Controller
public class UserController {

    @Autowired
    private User1Repository userRepository;

    @GetMapping("login")
    public String login(){
        return "loginpage";
    }

    @PostMapping("/user")
    @ResponseBody
    public String saveUser(@Valid @RequestBody AppUser user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "{\"result\": \"error\"}";
        }
        AppUser u = new AppUser();
        u.setEmail(user.getEmail());
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        userRepository.save(u);
        log.info("用户保存成功");
        return "{\"result\": \"success\"}";
    }
    /*@GetMapping(path = "/user")
    public void saveUser(@Valid @RequestParam String username, @Valid @RequestParam String password, @Valid @RequestParam String email, BindingResult res) {
        AppUser u = new AppUser();
        System.out.println(res);
        u.setEmail(email);
        u.setUsername(username);
        u.setPassword(password);
        userRepository.save(u);
    }*/

    @GetMapping(path = "/find")
    @ResponseBody
    //@LoggerManage(description = "查询" )
    public String findUser(@RequestParam int id) {
        return userRepository.findById(id).toString();
    }


}
