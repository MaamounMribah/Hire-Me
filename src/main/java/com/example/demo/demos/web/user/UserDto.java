package com.example.demo.demos.web.user;

import org.jetbrains.annotations.NotNull;

public class UserDto {
    @NotNull

    private String firstName;

    @NotNull
    private String lastName;

    @NotNull

    private String password;
    private String matchingPassword;

    @NotNull
    private String email;


}
