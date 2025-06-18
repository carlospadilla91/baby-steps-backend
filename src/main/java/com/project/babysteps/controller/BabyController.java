package com.project.babysteps.controller;

import com.project.babysteps.dto.BabyDto;
import com.project.babysteps.service.BabyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/babies")
public class BabyController {

    private final BabyService babyService;

    @Autowired
    public BabyController(BabyService babyService) {
        this.babyService = babyService;
    }

    @PostMapping()
    public ResponseEntity<BabyDto> createBaby(@RequestBody BabyDto babyDto, Authentication authentication) {
        String userEmail = authentication.getName();
        System.out.println("Authenticated user: " + userEmail);
        BabyDto createdBaby = babyService.createBaby(userEmail, babyDto);
        return ResponseEntity.ok(createdBaby);
    }

    @GetMapping
    public ResponseEntity<List<BabyDto>> getBabiesForUser(Authentication authentication) {
        String userEmail = authentication.getName();
        List<BabyDto> babies = babyService.getBabiesForUser(userEmail);
        return ResponseEntity.ok(babies);
    }

    // Get single baby
    @GetMapping("{id}")
    public ResponseEntity<BabyDto> getBabyById(@PathVariable Long id) {
        return babyService.getBabyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update baby
    @PutMapping("{id}")
    public ResponseEntity<BabyDto> updateBaby(@PathVariable Long id, @RequestBody BabyDto babyDto, Authentication authentication) {
        String userEmail = authentication.getName();
        BabyDto updatedBaby = babyService.updateBaby(id, userEmail, babyDto);
        return ResponseEntity.ok(updatedBaby);
    }
}
