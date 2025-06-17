package com.project.babysteps.service;

import com.project.babysteps.dto.DiaperChangeDto;
import java.util.List;
public interface DiaperChangeService {
    DiaperChangeDto createDiaperChange(DiaperChangeDto diaperChangeDto);
    List<DiaperChangeDto> getDiaperChangesByBabyId(Long babyId);
}
