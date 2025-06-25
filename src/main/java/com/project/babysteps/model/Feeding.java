package com.project.babysteps.model;

import com.project.babysteps.model.enums.FeedingType;
import com.project.babysteps.model.enums.FeedingUnit;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Feeding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime timestamp;
    private Double amount;
    @Enumerated(EnumType.STRING)
    private FeedingType type;

    @Enumerated(EnumType.STRING)
    private FeedingUnit unit;

    @ManyToOne
    @JoinColumn(name = "baby_id")
    private Baby baby;

    public Feeding() {
    }

    public Feeding(Long id, LocalDateTime timestamp, Double amount, FeedingType type, FeedingUnit unit, Baby baby) {
        this.id = id;
        this.timestamp = timestamp;
        this.amount = amount;
        this.type = type;
        this.unit = unit;
        this.baby = baby;
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

    public Baby getBaby() {
        return baby;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }

    public FeedingUnit getUnit() {
        return unit;
    }

    public void setUnit(FeedingUnit unit) {
        this.unit = unit;
    }
}
