package com.rockpago.yestion.time.dto;

import com.rockpago.yestion.time.entity.Time;
import lombok.Builder;
import lombok.Getter;

@Getter
public class TimeRequestDto {

    private Long id;
    private int hours;
    private int minutes;

    @Builder
    public TimeRequestDto(Long id, int hours, int minutes) {
        this.id = id;
        this.hours = hours;
        this.minutes = minutes;
    }

    public Time toEntity() {
        return Time.builder()
                .id(id)
                .hours(hours)
                .minutes(minutes)
                .build();
    }

}
