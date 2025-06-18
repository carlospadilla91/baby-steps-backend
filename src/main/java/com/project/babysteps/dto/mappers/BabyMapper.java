package com.project.babysteps.dto.mappers;

import com.project.babysteps.dto.BabyDto;
import com.project.babysteps.model.Baby;
import com.project.babysteps.model.User;

public class BabyMapper {

    public static BabyDto toDto(Baby baby) {
        return new BabyDto(
                baby.getId(),
                baby.getName(),
                baby.getGender(),
                baby.getDateOfBirth(),
                baby.getUser().getId()
        );
    }

    public static Baby toEntity(BabyDto dto, User user) {
        Baby baby = new Baby();
        baby.setId(dto.getId());
        baby.setName(dto.getName());
        baby.setGender(dto.getGender());
        baby.setDateOfBirth(dto.getDateOfBirth());
        baby.setUser(user);
        return baby;
    }
}
