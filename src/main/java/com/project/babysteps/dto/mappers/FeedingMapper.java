package com.project.babysteps.dto.mappers;

import com.project.babysteps.dto.FeedingDto;
import com.project.babysteps.model.Baby;
import com.project.babysteps.model.Feeding;

public class FeedingMapper {

    public static FeedingDto toDto(Feeding feeding) {
        FeedingDto feedingDto = new FeedingDto();
        feedingDto.setId(feeding.getId());
        feedingDto.setTimestamp(feeding.getTimestamp());
        feedingDto.setAmount(feeding.getAmount());
        feedingDto.setType(feeding.getType());
        feedingDto.setBabyId(feeding.getBaby().getId());
        return feedingDto;
    }

    public static Feeding toEntity(FeedingDto feedingDto, Baby baby) {
        Feeding feeding = new Feeding();
        feeding.setId(feedingDto.getId());
        feeding.setTimestamp(feedingDto.getTimestamp());
        feeding.setAmount(feedingDto.getAmount());
        feeding.setType(feedingDto.getType());
        feeding.setBaby(baby);
        return feeding;
    }
}
