package com.project.babysteps.dto.mappers;

import com.project.babysteps.dto.WeightEntryDto;
import com.project.babysteps.model.Baby;
import com.project.babysteps.model.WeightEntry;

public class WeightEntryMapper {

    public static WeightEntry toEntity(WeightEntryDto dto, Baby baby) {
        WeightEntry weightEntry = new WeightEntry();
        weightEntry.setId(dto.getId());
        weightEntry.setDate(dto.getDate());
        weightEntry.setWeight(dto.getWeight());
        weightEntry.setUnit(dto.getUnit());
        weightEntry.setBaby(baby);
        return weightEntry;
    }

    public static WeightEntryDto toDto(WeightEntry weightEntry) {
        WeightEntryDto dto = new WeightEntryDto();
        dto.setId(weightEntry.getId());
        dto.setDate(weightEntry.getDate());
        dto.setWeight(weightEntry.getWeight());
        dto.setUnit(weightEntry.getUnit());
        dto.setBabyId(weightEntry.getBaby().getId());
        return dto;
    }
}
