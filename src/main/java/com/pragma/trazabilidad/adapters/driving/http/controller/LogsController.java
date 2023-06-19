package com.pragma.trazabilidad.adapters.driving.http.controller;

import com.pragma.trazabilidad.adapters.driving.http.dto.request.LogsRequestDto;
import com.pragma.trazabilidad.adapters.driving.http.dto.response.LogsResponseDto;
import com.pragma.trazabilidad.adapters.driving.http.handler.LogsHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class LogsController {
    private final LogsHandler logHandler;

    @PostMapping("/log")
    public ResponseEntity<Map<String,String>> createLog(@RequestBody LogsRequestDto logDto){
        logHandler.saveLog(logDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                Collections.singletonMap("Message: ","log saved")
        );
    }
    @GetMapping("/log/{idOrder}")
    public List<LogsResponseDto> getTimesOrder(@PathVariable("idOrder") Long idOrder){
        return logHandler.timeStep(idOrder);
    }
    @GetMapping("/time/{idOrder}")
    public Long getTimeOrder(@PathVariable("idOrder") Long idOrder){
        return logHandler.totalTime(idOrder);
    }
}
