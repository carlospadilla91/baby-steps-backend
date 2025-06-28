package com.project.babysteps.controller;

import com.project.babysteps.dto.WeightEntryDto;
import com.project.babysteps.service.WeightEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weight-entries")
public class WeightEntryController {

    private final WeightEntryService weightEntryService;

    @Autowired
    public WeightEntryController(WeightEntryService weightEntryService) {
        this.weightEntryService = weightEntryService;
    }

    @PostMapping
    public ResponseEntity<WeightEntryDto> createWeightEntry(@RequestBody WeightEntryDto weightEntryDto) {
        return ResponseEntity.ok(weightEntryService.createWeightEntry(weightEntryDto));
    }

    @GetMapping("/{babyId}")
    public ResponseEntity<List<WeightEntryDto>> getWeightEntriesByBabyId(@PathVariable Long babyId) {
        return ResponseEntity.ok(weightEntryService.getWeightEntriesByBabyId(babyId));
    }
}
