package com.project.babysteps.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class DiaperChange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime timestamp;
    private boolean wet;
    private boolean dirty;
    private String notes;

    @ManyToOne
    private Baby baby;

}
