package com.project.babysteps.model;

import com.project.babysteps.model.enums.DiaperType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class DiaperChange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime timestamp;
    @Enumerated(EnumType.STRING)
    private DiaperType type;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "baby_id")
    private Baby baby;

    public DiaperChange() {}

    public DiaperChange(Long id, LocalDateTime timestamp, DiaperType type, String notes, Baby baby) {
        this.id = id;
        this.timestamp = timestamp;
        this.type = type;
        this.notes = notes;
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

    public Baby getBaby() {
        return baby;
    }

    public void setBaby(Baby baby) {
        this.baby = baby;
    }
}
