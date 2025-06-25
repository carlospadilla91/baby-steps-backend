package com.project.babysteps.dto;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public class NapDto {

    private Long id;
    @NotEmpty
    private LocalDateTime startTime;
    @NotEmpty
    private LocalDateTime endTime;
    private String notes;

    private Long babyId;

    public NapDto() {
    }
    public NapDto(Long id, LocalDateTime startTime, LocalDateTime endTime, String notes, Long babyId) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.notes = notes;
        this.babyId = babyId;
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

    public Long getBabyId() {
        return babyId;
    }

    public void setBabyId(Long babyId) {
        this.babyId = babyId;
    }
}
