package com.project.babysteps.service;

import com.project.babysteps.dto.WeightEntryDto;

import java.util.List;

public interface WeightEntryService {

    WeightEntryDto createWeightEntry(WeightEntryDto weightEntryDto);
    List<WeightEntryDto> getWeightEntriesByBabyId(Long babyId);
}
