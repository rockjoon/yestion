package com.rockpago.yestion.inputtime.domain;

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
public class Spent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int minutes;

    private int hours;

    @Builder
    public Spent(Long id, int minutes, int hours) {
        this.id = id;
        this.minutes = minutes;
        this.hours = hours;
    }
}
