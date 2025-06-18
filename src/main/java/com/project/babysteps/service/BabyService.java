package com.project.babysteps.service;

import com.project.babysteps.dto.BabyDto;

import java.util.List;
import java.util.Optional;

public interface BabyService {

    BabyDto createBaby(String userEmail, BabyDto babyDto);
    BabyDto updateBaby(Long id, String userEmail, BabyDto babyDto);
    List<BabyDto> getBabiesForUser(String userEmail);
    Optional<BabyDto> getBabyById(Long id);
}
