package com.project.babysteps.service;

import com.project.babysteps.model.Baby;

import java.util.List;

public interface BabyService {

    Baby createBaby(Baby baby);
    Baby updateBaby(Long id, Baby baby);
    List<Baby> getAllBabies();
    void deleteBaby(Long id);
}
