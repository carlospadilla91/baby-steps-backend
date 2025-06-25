package com.project.babysteps.controller;

import com.project.babysteps.dto.NapDto;
import com.project.babysteps.service.NapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/naps")
public class NapController {

    private final NapService napService;

    @Autowired
    public NapController(NapService napService) {
        this.napService = napService;
    }

    @PostMapping
    public ResponseEntity<NapDto> createNap(@RequestBody NapDto napDto) {
        return ResponseEntity.ok(napService.createNap(napDto));
    }

    @GetMapping("/{babyId}")
    public ResponseEntity<List<NapDto>> getNapsByBabyId(@PathVariable Long babyId) {
        return ResponseEntity.ok(napService.getNapsByBabyId(babyId));
    }
}
