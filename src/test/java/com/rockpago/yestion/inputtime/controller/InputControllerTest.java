package com.rockpago.yestion.inputtime.controller;

import com.rockpago.yestion.inputtime.domain.InputRepository;
import com.rockpago.yestion.inputtime.domain.Spent;
import com.rockpago.yestion.inputtime.dto.InputRequestDto;
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
class InputControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private InputRepository inputRepository;

    @AfterEach
    public void tearDown() throws Exception {
        inputRepository.deleteAll();
    }

    @DisplayName("Spent 등록 확인")
    @Test
    void saveTest() {
        int hours = 1;
        int minutes = 30;
        InputRequestDto input = InputRequestDto.builder()
                .hours(hours)
                .minutes(minutes)
                .build();

        String url = "http://localhost:" + port + "/spents";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, input, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Spent> list = inputRepository.findAll();
        Spent resultSpent = list.get(0);
        assertThat(resultSpent.getHours()).isEqualTo(hours);
        assertThat(resultSpent.getMinutes()).isEqualTo(minutes);


    }















}