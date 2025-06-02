package com.project.babysteps.dto.mappers;

import com.project.babysteps.dto.BabyDto;
import com.project.babysteps.model.Baby;

public class BabyMapper {

    public static BabyDto toDto(Baby baby) {
        return new BabyDto(
                baby.getId(),
                baby.getName(),
                baby.getGender(),
                baby.getDateOfBirth()
        );
    }

    public static Baby toEntity(BabyDto dto) {
        Baby baby = new Baby();
        baby.setId(dto.getId());
        baby.setName(dto.getName());
        baby.setGender(dto.getGender());
        baby.setDateOfBirth(dto.getDateOfBirth());
        return baby;
    }
}
