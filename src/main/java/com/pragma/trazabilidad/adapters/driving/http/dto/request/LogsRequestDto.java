package com.pragma.trazabilidad.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LogsRequestDto {
    private Long idOrder;
    private LocalDateTime pending;
    private LocalDateTime inPreparation;
    private LocalDateTime ready;
    private LocalDateTime delivered;
}
