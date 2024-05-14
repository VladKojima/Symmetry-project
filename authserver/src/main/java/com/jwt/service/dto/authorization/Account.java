package com.jwt.service.dto.authorization;

import lombok.Data;

@Data
public class Account {

    private String login;

    private String password;

    private Roles role;

}
