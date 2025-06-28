package com.project.babysteps.service.impl;

import com.project.babysteps.dto.WeightEntryDto;
import com.project.babysteps.dto.mappers.WeightEntryMapper;
import com.project.babysteps.model.Baby;
import com.project.babysteps.model.WeightEntry;
import com.project.babysteps.repository.BabyRepository;
import com.project.babysteps.repository.WeightEntryRepository;
import com.project.babysteps.service.WeightEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeightEntryServiceImpl implements WeightEntryService {

    @Autowired
    private WeightEntryRepository weightEntryRepository;

    @Autowired
    private BabyRepository babyRepository;

    @Override
    public WeightEntryDto createWeightEntry(WeightEntryDto weightEntryDto) {
        Baby baby = babyRepository.findById(weightEntryDto.getBabyId())
                .orElseThrow(() -> new RuntimeException("Baby not found"));
        WeightEntry weightEntry = WeightEntryMapper.toEntity(weightEntryDto, baby);
        WeightEntry savedWeightEntry = weightEntryRepository.save(weightEntry);
        return WeightEntryMapper.toDto(savedWeightEntry);

    }

    @Override
    public List<WeightEntryDto> getWeightEntriesByBabyId(Long babyId) {
        return weightEntryRepository
                .findByBabyId(babyId)
                .stream()
                .map(WeightEntryMapper::toDto)
                .collect(Collectors.toList());
    }
}
