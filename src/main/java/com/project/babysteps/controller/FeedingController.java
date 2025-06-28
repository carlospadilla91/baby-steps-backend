package com.project.babysteps.controller;

import com.project.babysteps.dto.FeedingDto;
import com.project.babysteps.service.FeedingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feeding")
public class FeedingController {

    private final FeedingService feedingService;

    @Autowired
    public FeedingController(FeedingService feedingService) {this.feedingService = feedingService;}

    @PostMapping
    public ResponseEntity<FeedingDto> createFeeding(@RequestBody FeedingDto feedingDto) {
        return ResponseEntity.ok(feedingService.createFeeding(feedingDto));
    }

    @GetMapping("/{babyId}")
    public ResponseEntity<List<FeedingDto>> getFeedingsByBabyId(@PathVariable Long babyId) {
        return ResponseEntity.ok(feedingService.getFeedingsByBabyId(babyId));
    }
}
