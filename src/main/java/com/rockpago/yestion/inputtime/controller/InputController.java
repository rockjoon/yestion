package com.rockpago.yestion.inputtime.controller;

import com.rockpago.yestion.inputtime.dto.InputRequestDto;
import com.rockpago.yestion.inputtime.service.InputService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class InputController {

    private final InputService inputService;

    @PostMapping("/spents")
    public ResponseEntity<Long> inputTime(@RequestBody final InputRequestDto req) {
        final Long id = inputService.save(req);
        return ResponseEntity.ok(id);
    }



}
