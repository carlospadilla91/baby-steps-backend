package com.project.babysteps.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name cannot be blank")
    private String name;
    @Column(unique = true)
    @NotEmpty(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    private String email;
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Baby> babies;

}
