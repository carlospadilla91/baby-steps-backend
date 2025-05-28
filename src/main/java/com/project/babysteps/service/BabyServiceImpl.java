package com.project.babysteps.service;

import com.project.babysteps.model.Baby;
import com.project.babysteps.repository.BabyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BabyServiceImpl implements BabyService {

    private final BabyRepository babyRepository;

    @Autowired
    public BabyServiceImpl(BabyRepository babyRepository) {
        this.babyRepository = babyRepository;
    }

    @Override
    public Baby createBaby(Baby baby) {
        return babyRepository.save(baby);
    }

    @Override
    public Baby updateBaby(Long id, Baby babyDetails) {
        return babyRepository.findById(id)
                .map(baby -> {
                    baby.setName(babyDetails.getName());
                    baby.setGender(babyDetails.getGender());
                    baby.setDateOfBirth(babyDetails.getDateOfBirth());
                    baby.setWeight(babyDetails.getWeight());
                    return babyRepository.save(baby);
                })
                .orElseThrow(() -> new RuntimeException("Baby not found"));
    }

    @Override
    public List<Baby> getAllBabies() {
        return babyRepository.findAll();
    }

    @Override
    public void deleteBaby(Long id) {
        babyRepository.deleteById(id);
    }
}
