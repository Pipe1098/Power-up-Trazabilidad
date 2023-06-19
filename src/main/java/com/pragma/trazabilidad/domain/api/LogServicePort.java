package com.pragma.trazabilidad.domain.api;

import com.pragma.trazabilidad.adapters.driving.http.dto.response.LogsResponseDto;
import com.pragma.trazabilidad.domain.model.Log;

import java.util.List;


public interface LogServicePort {
    void saveLog(Log log);
    List<LogsResponseDto> timeStates(Long idOrder);
    Long totalTime(Long idOrder);
}
