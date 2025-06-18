package com.project.babysteps.controller;

import com.project.babysteps.dto.DiaperChangeDto;
import com.project.babysteps.service.DiaperChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diaper-changes")
public class DiaperChangeController {

    private final DiaperChangeService diaperChangeService;

    @Autowired
    public DiaperChangeController(DiaperChangeService diaperChangeService) {
        this.diaperChangeService = diaperChangeService;
    }

    @PostMapping
    public ResponseEntity<DiaperChangeDto> create(@RequestBody DiaperChangeDto dto) {
        return ResponseEntity.ok(diaperChangeService.createDiaperChange(dto));
    }

    @GetMapping("/{babyId}")
    public ResponseEntity<List<DiaperChangeDto>> getByBabyId(@PathVariable Long babyId) {
        return ResponseEntity.ok(diaperChangeService.getDiaperChangesByBabyId(babyId));
    }
}
