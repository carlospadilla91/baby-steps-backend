package com.project.babysteps.dto;

import com.project.babysteps.model.enums.DiaperType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class DiaperChangeDto {

    private Long id;
    @NotEmpty
    private LocalDateTime timestamp;
    @NotEmpty
    private DiaperType type;
    @Size(max = 255)
    private String notes;
    private Long babyId;

    public DiaperChangeDto() {}

    public DiaperChangeDto(Long id, LocalDateTime timestamp, DiaperType type, String notes, Long babyId) {
        this.id = id;
        this.timestamp = timestamp;
        this.type = type;
        this.notes = notes;
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

    public DiaperType getType() {
        return type;
    }

    public void setType(DiaperType type) {
        this.type = type;
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
