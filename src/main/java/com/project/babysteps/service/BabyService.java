package com.project.babysteps.service;

import com.project.babysteps.dto.BabyDto;
import com.project.babysteps.model.Baby;

import java.util.List;
import java.util.Optional;

public interface BabyService {

    BabyDto createBaby(Long userId, BabyDto babyDto);
    Baby updateBaby(Long id, BabyDto babyDto);
    List<BabyDto> getBabiesForUser(Long userId);
    Optional<BabyDto> getBabyById(Long id);
}
