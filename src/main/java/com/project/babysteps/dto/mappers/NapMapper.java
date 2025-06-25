package com.project.babysteps.dto.mappers;

import com.project.babysteps.dto.NapDto;
import com.project.babysteps.model.Baby;
import com.project.babysteps.model.Nap;

public class NapMapper {

    public static NapDto toDto(Nap nap) {
        NapDto napDto = new NapDto();
        napDto.setId(nap.getId());
        napDto.setStartTime(nap.getStartTime());
        napDto.setEndTime(nap.getEndTime());
        napDto.setNotes(nap.getNotes());
        napDto.setBabyId(nap.getBaby().getId());
        return napDto;
    }

    public static Nap toEntity(NapDto dto, Baby baby) {
        Nap nap = new Nap();
        nap.setId(dto.getId());
        nap.setStartTime(dto.getStartTime());
        nap.setEndTime(dto.getEndTime());
        nap.setNotes(dto.getNotes());
        nap.setBaby(baby);
        return nap;
    }
}
