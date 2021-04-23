package com.rockpago.yestion.time.controller;

import com.rockpago.yestion.time.dto.TimeRequestDto;
import com.rockpago.yestion.time.service.TimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TimeApiController {

    private final TimeService timeService;

    @PostMapping("/times")
    public ResponseEntity<Long> inputTime(@RequestBody final TimeRequestDto dto) {
        final Long id = timeService.save(dto);
        return ResponseEntity.ok(id);
    }

}
