package com.rockpago.yestion.time.controller;

import com.rockpago.yestion.time.domain.TimeRepository;
import com.rockpago.yestion.time.domain.Time;
import com.rockpago.yestion.time.dto.TimeRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TimeApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private TimeRepository timeRepository;

    @AfterEach
    public void tearDown() throws Exception {
        timeRepository.deleteAll();
    }

    @DisplayName("Time 등록 확인")
    @Test
    void saveTest() {
        int hours = 1;
        int minutes = 30;
        TimeRequestDto input = TimeRequestDto.builder()
                .hours(hours)
                .minutes(minutes)
                .build();

        String url = "http://localhost:" + port + "/times";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, input, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Time> list = timeRepository.findAll();
        Time resultTime = list.get(0);
        assertThat(resultTime.getHours()).isEqualTo(hours);
        assertThat(resultTime.getMinutes()).isEqualTo(minutes);

    }















}