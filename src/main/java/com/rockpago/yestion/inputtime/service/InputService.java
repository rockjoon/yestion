package com.rockpago.yestion.inputtime.service;

import com.rockpago.yestion.inputtime.domain.InputRepository;
import com.rockpago.yestion.inputtime.dto.InputRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class InputService {

    private final InputRepository inputRepository;

    public Long save(InputRequestDto req) {
        return inputRepository.save(req.toEntity()).getId();
    }
}
