package com.startboot.dev.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class User {

    /*用户id*/
    @Id
    private String userid;

    /*用户名*/
    private String username;

    /*用户密码*/
    private String password;

    /*用户email*/
    private String email;
}