package com.rockpago.yestion.time.service;

import com.rockpago.yestion.time.domain.TimeRepository;
import com.rockpago.yestion.time.dto.TimeRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TimeService {

    private final TimeRepository timeRepository;

    public Long save(TimeRequestDto req) {
        return timeRepository.save(req.toEntity()).getId();
    }
}
