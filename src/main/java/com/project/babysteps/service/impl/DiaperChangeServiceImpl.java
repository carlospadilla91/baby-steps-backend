package com.project.babysteps.service.impl;

import com.project.babysteps.dto.DiaperChangeDto;
import com.project.babysteps.dto.mappers.DiaperChangeMapper;
import com.project.babysteps.model.Baby;
import com.project.babysteps.model.DiaperChange;
import com.project.babysteps.repository.BabyRepository;
import com.project.babysteps.repository.DiaperChangeRepository;
import com.project.babysteps.service.DiaperChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiaperChangeServiceImpl implements DiaperChangeService {

    @Autowired
    DiaperChangeRepository diaperChangeRepository;

    @Autowired
    BabyRepository babyRepository;

    @Override
    public DiaperChangeDto createDiaperChange(DiaperChangeDto diaperChangeDto) {
        Baby baby = babyRepository.findById(diaperChangeDto.getBabyId())
                .orElseThrow(() -> new RuntimeException("Baby not found"));

        DiaperChange diaperChange = DiaperChangeMapper.toEntity(diaperChangeDto, baby);
        DiaperChange savedDiaperChange = diaperChangeRepository.save(diaperChange);
        return DiaperChangeMapper.toDto(savedDiaperChange);
    }

    @Override
    public List<DiaperChangeDto> getDiaperChangesByBabyId(Long babyId) {
        return diaperChangeRepository
                .findByBabyId(babyId)
                .stream()
                .map(DiaperChangeMapper::toDto)
                .collect(Collectors.toList());
    }
}
