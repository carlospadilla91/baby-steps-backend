package com.project.babysteps.service.impl;

import com.project.babysteps.dto.BabyDto;
import com.project.babysteps.dto.mappers.BabyMapper;
import com.project.babysteps.model.Baby;
import com.project.babysteps.model.User;
import com.project.babysteps.repository.BabyRepository;
import com.project.babysteps.repository.UserRepo;
import com.project.babysteps.service.BabyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
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
    public BabyDto createBaby(String userEmail, BabyDto babyDto) {
        User user = userRepo.findByEmail(userEmail)
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
    public BabyDto updateBaby(Long id, String userEmail, BabyDto babyDto) {
        Baby existingBaby = babyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Baby not found"));
        User user = userRepo.findByEmail(userEmail)
                        .orElseThrow(() -> new RuntimeException("User not found"));

        if (!existingBaby.getUser().getId().equals(user.getId())) {
            throw new AccessDeniedException("You do not have permission to update this baby");
        }

        existingBaby.setName(babyDto.getName());
        existingBaby.setDateOfBirth(babyDto.getDateOfBirth());
        existingBaby.setGender(babyDto.getGender());

        Baby savedBaby = babyRepository.save(existingBaby);
        return BabyMapper.toDto(savedBaby);
    }

    @Override
    public List<BabyDto> getBabiesForUser(String userEmail) {
        return babyRepository.findByUserEmail(userEmail)
                .stream()
                .map(BabyMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BabyDto> getBabyById(Long id) {
        return babyRepository.findById(id).map(BabyMapper::toDto);
    }
}
