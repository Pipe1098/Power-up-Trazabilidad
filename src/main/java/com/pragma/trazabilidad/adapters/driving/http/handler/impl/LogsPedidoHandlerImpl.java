package com.pragma.trazabilidad.adapters.driving.http.handler.impl;


import com.pragma.trazabilidad.adapters.driving.http.dto.request.LogsRequestDto;
import com.pragma.trazabilidad.adapters.driving.http.dto.response.LogsResponseDto;
import com.pragma.trazabilidad.adapters.driving.http.handler.LogsHandler;
import com.pragma.trazabilidad.adapters.driving.http.mapper.LogDtoMapper;
import com.pragma.trazabilidad.domain.api.LogServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogsPedidoHandlerImpl implements LogsHandler {

    private final LogServicePort logServicePort;
    private final LogDtoMapper logDtoMapper;
    @Override
    public void saveLog(LogsRequestDto logDto) {
        logServicePort.saveLog(logDtoMapper.toLog(logDto));
    }
    @Override
    public List<LogsResponseDto> timeStep(Long idOrder) {
        return logServicePort.timeStates(idOrder);
    }

    @Override
    public Long totalTime(Long idOrder) {
        return logServicePort.totalTime(idOrder);
    }
}
