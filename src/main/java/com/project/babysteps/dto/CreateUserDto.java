package com.project.babysteps.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateUserDto {
    @NotEmpty
    private String name;
    @NotEmpty
    @Email
    private String email;
    @Size(min = 6)
    private String password;

    public CreateUserDto() {}

    public CreateUserDto(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
