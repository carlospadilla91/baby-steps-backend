package com.project.babysteps.dto.mappers;

import com.project.babysteps.dto.DiaperChangeDto;
import com.project.babysteps.model.Baby;
import com.project.babysteps.model.DiaperChange;

public class DiaperChangeMapper {

    public static DiaperChangeDto toDto(DiaperChange diaperChange) {
        DiaperChangeDto diaperChangeDto = new DiaperChangeDto();
        diaperChangeDto.setId(diaperChange.getId());
        diaperChangeDto.setTimestamp(diaperChange.getTimestamp());
        diaperChangeDto.setType(diaperChange.getType());
        diaperChangeDto.setNotes(diaperChange.getNotes());
        diaperChangeDto.setBabyId(diaperChange.getBaby().getId());
        return diaperChangeDto;
    }

    public static DiaperChange toEntity(DiaperChangeDto dto, Baby baby) {
        DiaperChange diaperChange = new DiaperChange();
        diaperChange.setId(dto.getId());
        diaperChange.setTimestamp(dto.getTimestamp());
        diaperChange.setType(dto.getType());
        diaperChange.setNotes(dto.getNotes());
        diaperChange.setBaby(baby);
        return diaperChange;
    }
}
