package com.rockpago.yestion.time.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TimeIndexController.class)
class TimeIndexControllerTest {

    @Autowired
    MockMvc mockMvc;

    @DisplayName("Time home 페이지 요청")
    @Test
    void timehome() throws Exception {
        mockMvc.perform(get("/timehome"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("YESTION")))
                .andDo(print());
    }

}