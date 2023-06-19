package com.pragma.trazabilidad.adapters.driving.http.handler;

import com.pragma.trazabilidad.adapters.driving.http.dto.request.LogsRequestDto;
import com.pragma.trazabilidad.adapters.driving.http.dto.response.LogsResponseDto;

import java.util.List;

public interface LogsHandler {

    void saveLog(LogsRequestDto pedidoDto);
    List<LogsResponseDto> timeStep(Long idPedido);
    Long totalTime(Long idOrder);
}
