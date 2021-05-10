package com.rockpago.yestion.time.service;

import com.rockpago.yestion.time.entity.Time;
import com.rockpago.yestion.time.entity.TimeRepository;
import com.rockpago.yestion.time.dto.TimeRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class TimeServiceTest {

    @InjectMocks
    private TimeService timeService;

    @Mock
    TimeRepository timeRepository;

    @DisplayName("Time 등록 서비스 테스트")
    @Test
    void save() {
        Long id = 1L;
        int hours = 1;
        int minutes = 30;

        TimeRequestDto dto = TimeRequestDto.builder()
                .id(id)
                .hours(hours)
                .minutes(minutes)
                .build();

        Time time = Time.builder()
                .id(id)
                .hours(hours)
                .minutes(minutes)
                .build();

        given(timeRepository.save(any())).willReturn(time);

        Long result = timeService.save(dto);

        assertThat(result).isEqualTo(id);

    }

}