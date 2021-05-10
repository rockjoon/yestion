package com.rockpago.yestion.time.entity;

import com.rockpago.yestion.time.entity.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, Long> {
}
