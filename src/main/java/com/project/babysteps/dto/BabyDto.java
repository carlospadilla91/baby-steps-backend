package com.project.babysteps.dto;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
public class BabyDto {

    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String gender;
    @NotEmpty
    private LocalDate dateOfBirth;

    public BabyDto() {}

    public BabyDto(Long id, String name, String gender, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
