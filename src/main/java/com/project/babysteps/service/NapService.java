package com.project.babysteps.service;

import com.project.babysteps.dto.NapDto;

import java.util.List;

public interface NapService {

    NapDto createNap(NapDto napDto);
    List<NapDto> getNapsByBabyId(Long babyId);
}
