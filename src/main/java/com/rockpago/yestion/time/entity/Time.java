package com.rockpago.yestion.time.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer minutes;

    private Integer hours;


    @Builder
    public Time(Long id, Integer minutes, Integer hours) {
        this.id = id;
        this.minutes = minutes;
        this.hours = hours;
    }
}
