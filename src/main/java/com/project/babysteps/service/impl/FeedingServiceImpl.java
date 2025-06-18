package com.project.babysteps.service.impl;

import com.project.babysteps.dto.FeedingDto;
import com.project.babysteps.dto.mappers.FeedingMapper;
import com.project.babysteps.model.Baby;
import com.project.babysteps.model.Feeding;
import com.project.babysteps.repository.BabyRepository;
import com.project.babysteps.repository.FeedingRepository;
import com.project.babysteps.service.FeedingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedingServiceImpl implements FeedingService {

    @Autowired
    private FeedingRepository feedingRepository;

    @Autowired
    private BabyRepository babyRepository;

    @Override
    public FeedingDto createFeeding(FeedingDto feedingDto) {
        Baby baby = babyRepository.findById(feedingDto.getBabyId())
                .orElseThrow(() -> new RuntimeException("Baby not found"));
        Feeding feeding = FeedingMapper.toEntity(feedingDto, baby);
        Feeding savedFeeding = feedingRepository.save(feeding);
        return FeedingMapper.toDto(savedFeeding);
    }

    @Override
    public List<FeedingDto> getFeedingsByBabyId(Long babyId) {
        return feedingRepository
                .findByBabyId(babyId)
                .stream()
                .map(FeedingMapper::toDto)
                .collect(Collectors.toList());
    }
}
