package com.project.babysteps.service;

import com.project.babysteps.dto.FeedingDto;

import java.util.List;

public interface FeedingService {

    FeedingDto createFeeding(FeedingDto feedingDto);
    List<FeedingDto> getFeedingsByBabyId(Long babyId);
}
