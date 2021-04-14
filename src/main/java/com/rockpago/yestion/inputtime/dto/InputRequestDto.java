package com.rockpago.yestion.inputtime.dto;

import com.rockpago.yestion.inputtime.domain.Spent;
import lombok.Builder;
import lombok.Getter;

@Getter
public class InputRequestDto {

    private Long id;
    private int hours;
    private int minutes;

    @Builder
    public InputRequestDto(Long id, int hours, int minutes) {
        this.id = id;
        this.hours = hours;
        this.minutes = minutes;
    }

    public Spent toEntity() {
        return Spent.builder()
                .id(id)
                .hours(hours)
                .minutes(minutes)
                .build();
    }

}
