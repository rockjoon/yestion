package com.rockpago.yestion.time.controller;

import com.rockpago.yestion.time.entity.TimeRepository;
import com.rockpago.yestion.time.entity.Time;
import com.rockpago.yestion.time.dto.TimeRequestDto;
import com.rockpago.yestion.time.service.TimeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class TimeApiControllerTest {

    @Autowired
    private TimeRepository timeRepository;

    @Autowired
    private TimeService timeService;

    @DisplayName("Time 등록 확인")
    @Test
    void saveTest() {
        int hours = 1;
        int minutes = 30;
        TimeRequestDto input = TimeRequestDto.builder()
                .hours(hours)
                .minutes(minutes)
                .build();

        Long id = timeService.save(input);

        Time time = timeRepository.findById(id).get();
        assertThat(time.getHours()).isEqualTo(hours);

    }















}