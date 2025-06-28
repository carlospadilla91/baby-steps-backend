package com.project.babysteps.dto;

import com.project.babysteps.model.enums.WeightUnit;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public class WeightEntryDto {

    private Long id;
    @NotEmpty
    private LocalDate date;
    @NotEmpty
    private Double weight;
    @NotEmpty
    private WeightUnit unit;
    private Long babyId;

    public WeightEntryDto() {
    }

    public WeightEntryDto(Long id, LocalDate date, Double weight, WeightUnit unit, Long babyId) {
        this.id = id;
        this.date = date;
        this.weight = weight;
        this.unit = unit;
        this.babyId = babyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public WeightUnit getUnit() {
        return unit;
    }

    public void setUnit(WeightUnit unit) {
        this.unit = unit;
    }

    public Long getBabyId() {
        return babyId;
    }

    public void setBabyId(Long babyId) {
        this.babyId = babyId;
    }
}
