package com.example.bank.dto;


import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserDto {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Timestamp createdOn;
}
