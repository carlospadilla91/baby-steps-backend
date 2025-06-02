package com.project.babysteps.service;

import com.project.babysteps.dto.BabyDto;
import com.project.babysteps.dto.mappers.BabyMapper;
import com.project.babysteps.model.Baby;
import com.project.babysteps.model.User;
import com.project.babysteps.repository.BabyRepository;
import com.project.babysteps.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BabyServiceImpl implements BabyService {

    private final BabyRepository babyRepository;
    private final UserRepo userRepo;

    @Autowired
    public BabyServiceImpl(BabyRepository babyRepository, UserRepo userRepo) {
        this.babyRepository = babyRepository;
        this.userRepo = userRepo;
    }

    @Override
    public BabyDto createBaby(Long userId, BabyDto babyDto) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Baby baby = new Baby();
        baby.setName(babyDto.getName());
        baby.setGender(babyDto.getGender());
        baby.setDateOfBirth(babyDto.getDateOfBirth());
        baby.setUser(user);

        Baby saved = babyRepository.save(baby);
        return BabyMapper.toDto(saved);
    }

    @Override
    public Baby updateBaby(Long id, BabyDto babyDto) {
        Baby baby = babyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Baby not found"));
        baby.setName(babyDto.getName());
        baby.setDateOfBirth(babyDto.getDateOfBirth());
        baby.setGender(babyDto.getGender());

        return babyRepository.save(baby);
    }

    @Override
    public List<BabyDto> getBabiesForUser(Long userId) {
        return babyRepository.findByUserId(userId)
                .stream()
                .map(BabyMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BabyDto> getBabyById(Long id) {
        return babyRepository.findById(id).map(BabyMapper::toDto);
    }
}
