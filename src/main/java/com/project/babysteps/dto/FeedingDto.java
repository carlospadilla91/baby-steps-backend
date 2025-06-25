package com.project.babysteps.dto;

import com.project.babysteps.model.enums.FeedingType;
import com.project.babysteps.model.enums.FeedingUnit;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public class FeedingDto {

    private Long id;
    @NotEmpty
    private LocalDateTime timestamp;
    private Double amount;
    private FeedingType type;
    private FeedingUnit unit;
    private Long babyId;

    public FeedingDto() {
    }

    public FeedingDto(Long id, LocalDateTime timestamp, Double amount, FeedingType type, FeedingUnit unit, Long babyId) {
        this.id = id;
        this.timestamp = timestamp;
        this.amount = amount;
        this.type = type;
        this.unit = unit;
        this.babyId = babyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public FeedingType getType() {
        return type;
    }

    public void setType(FeedingType type) {
        this.type = type;
    }

    public Long getBabyId() {
        return babyId;
    }

    public FeedingUnit getUnit() {
        return unit;
    }

    public void setUnit(FeedingUnit unit) {
        this.unit = unit;
    }

    public void setBabyId(Long babyId) {
        this.babyId = babyId;
    }
}
