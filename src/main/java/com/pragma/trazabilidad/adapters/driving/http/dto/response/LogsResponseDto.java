package com.pragma.trazabilidad.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Duration;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogsResponseDto {
    private Long idOrder;
    private Long duration1;
    private Long duration2;
    private Long duration3;
    private Long totalDuration;
}
