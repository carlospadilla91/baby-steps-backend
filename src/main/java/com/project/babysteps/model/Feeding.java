package com.project.babysteps.model;

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

    @ManyToOne
    @JoinColumn(name = "baby_id")
    private Baby baby;

    public Feeding() {
    }

    public Feeding(Long id, LocalDateTime timestamp, Double amount, FeedingType type, Baby baby) {
        this.id = id;
        this.timestamp = timestamp;
        this.amount = amount;
        this.type = type;
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
}
