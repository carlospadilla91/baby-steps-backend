package com.project.babysteps.service.impl;

import com.project.babysteps.dto.NapDto;
import com.project.babysteps.dto.mappers.NapMapper;
import com.project.babysteps.model.Baby;
import com.project.babysteps.model.Nap;
import com.project.babysteps.repository.BabyRepository;
import com.project.babysteps.repository.NapRepository;
import com.project.babysteps.service.NapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NapServiceImpl implements NapService {

    @Autowired
    private NapRepository napRepository;

    @Autowired
    private BabyRepository babyRepository;

    @Override
    public NapDto createNap(NapDto napDto) {
        Baby baby = babyRepository.findById(napDto.getBabyId())
                .orElseThrow(() -> new RuntimeException("Baby not found"));

        Nap nap = NapMapper.toEntity(napDto, baby);
        Nap savedNap = napRepository.save(nap);
        return NapMapper.toDto(savedNap);
    }

    @Override
    public List<NapDto> getNapsByBabyId(Long babyId) {
        return napRepository
                .findByBabyId(babyId)
                .stream()
                .map(NapMapper::toDto)
                .collect(Collectors.toList());
    }
}
