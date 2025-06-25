package com.project.babysteps.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Nap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "baby_id")
    private Baby baby;

    public Nap(Long id, LocalDateTime startTime, LocalDateTime endTime, String notes, Baby baby) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.notes = notes;
        this.baby = baby;
    }

    public Nap() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Baby getBaby() {
        return baby;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }
}
