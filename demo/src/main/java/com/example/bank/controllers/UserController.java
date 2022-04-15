package com.example.bank.controllers;

import com.example.bank.dto.UserDto;
import com.example.bank.model.UserEntity;
import com.example.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping
    public UserEntity createUser(@RequestBody UserDto userDto) {
        UserEntity created = userService.createUser(userDto);
        return created;
    }

    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable Integer id,
                                 @RequestBody UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        userService.deleteUser(id);
    }

    @GetMapping("/all")
    public List<UserEntity> allUsers(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserEntity searchById(@PathVariable Integer id){
        return userService.searchById(id);
    }



}
