package com.rockpago.yestion.time.domain;

import com.rockpago.yestion.time.entity.Time;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TimeTest {

    @DisplayName("Time Entity Builder 확인")
    @Test
    void build() {
        int minutes = 30;
        int hours = 1;

        Time time = Time.builder()
                .hours(hours)
                .minutes(minutes)
                .build();

        assertThat(time.getHours()).isEqualTo(hours);
        assertThat(time.getMinutes()).isEqualTo(minutes);
    }

}