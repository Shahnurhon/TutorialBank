package com.example.bank.service;

import com.example.bank.dto.UserDto;
import com.example.bank.model.UserEntity;
import com.example.bank.model.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public UserEntity createUser(UserDto userDto) {
        log.info("Create user {}", userDto);
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDto.getUsername());
        userEntity.setPassword(userDto.getPassword());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setCreatedOn(Timestamp.valueOf(LocalDateTime.now()));

        return userRepository.save(userEntity);
    }

    public UserEntity updateUser(Integer id, UserDto userDto) {

        UserEntity user = userRepository.findById(id).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("not found");
        }
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setCreatedOn(Timestamp.valueOf(LocalDateTime.now()));

        return userRepository.save(user);
    }

    public void deleteUser (Integer id){
        userRepository.findById(id).orElseThrow(() -> new RuntimeException());
        userRepository.deleteById(id);
    }

    public UserEntity searchById(Integer id){
         return userRepository.findById(id).orElse(null);
    }


}
